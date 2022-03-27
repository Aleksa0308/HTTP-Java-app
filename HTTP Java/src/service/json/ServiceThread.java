package service.json;



import http.HttpMethod;
import service.app.RequestHandler;
import service.json.response.Response;

import java.io.*;
import java.net.Socket;
import java.util.StringTokenizer;

public class ServiceThread implements Runnable {
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;

    public ServiceThread(Socket client) {
        this.client = client;
        try {
            //inicijalizacija ulaznog toka
            in = new BufferedReader(
                    new InputStreamReader(
                            client.getInputStream()));

            //inicijalizacija izlaznog sistema
            out = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    client.getOutputStream())), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {

            // uzimamo samo prvu liniju zahteva, iz koje dobijamo HTTP method i putanju
            String requestLine = in.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(requestLine);

            String method = stringTokenizer.nextToken();
            String path = stringTokenizer.nextToken();

            System.out.println("\nHTTP ZAHTEV KLIJENTA:\n");
            do {
                System.out.println(requestLine);
                requestLine = in.readLine();
            } while (!requestLine.trim().equals(""));


            System.out.println("--------->" + method +" " + path + "<-------------" );

            Request request = new Request(HttpMethod.valueOf(method), path);

            RequestHandler requestHandler = new RequestHandler();
            Response response = requestHandler.handle(request);

            System.out.println("\nHTTP odgovor:\n");
            System.out.println(response.getResponseString());

            out.println(response.getResponseString());

            in.close();
            out.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
