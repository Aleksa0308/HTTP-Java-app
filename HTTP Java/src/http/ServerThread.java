package http;

import app.Quotes;
import app.RequestHandler;
import http.response.Response;
import service.json.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

public class ServerThread implements Runnable {

    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private String author;
    private String quote;
    private int i;
    public ServerThread(Socket sock) {
        this.client = sock;

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

    public void run() {
        try {
            Socket socket = new Socket("localhost", Service.Service_PORT);
            new Thread(new Client(socket)).start();
            // uzimamo samo prvu liniju zahteva, iz koje dobijamo HTTP method i putanju
            String requestLine = in.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(requestLine);

            String method = stringTokenizer.nextToken();
            String path = stringTokenizer.nextToken();

            System.out.println("\nHTTP ZAHTEV KLIJENTA:\n");
            do {
                System.out.println(requestLine);
                requestLine = in.readLine();
                if(requestLine.contains("Content-Length:")){
                    String temp = requestLine;
                    String niz[] = temp.split(" ");
                    i = Integer.parseInt(niz[1]);
                }
            } while (!requestLine.trim().equals(""));

            if (method.equals(HttpMethod.POST.toString())) {
                char[] buffer = new char[i];
                in.read(buffer);
                String ans = new String(buffer);
                System.out.println(ans);
                handlePost(ans);
            }

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
    private void handlePost(String ans){

        String sve[] = ans.split("=");
        String sve2[] = sve[1].split("&");
        author = sve2[0].replace("+"," ");
        quote = sve[2].replace("+", " ");
        quote = quote.replace("%27", "\'");
        quote = quote.replace("%2C", ",");
        quote = quote.replace("%3F", "?");
        Quotes quotes = new Quotes(author, quote);
        Server.sviQuotes.add(quotes);
    }
}
