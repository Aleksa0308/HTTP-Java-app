package http;

import app.QuoteOfTheDay;
import com.google.gson.Gson;
import service.json.Service;

import java.io.*;
import java.net.Socket;

public class Client {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    public Client(Socket socket) throws IOException {
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
    }


    public static void main(String[] args) throws IOException {
        String httpZahtev= "GET /qod HTTP/1.1\n" +
                "Host: localhost:8081\n";

        String requestLine;
        String qod;
        Socket socket = new Socket("localhost", Service.Service_PORT);
        Client client = new Client(socket);
        client.out.println(httpZahtev);
        requestLine = client.in.readLine();
        do {
            System.out.println(requestLine);
            requestLine = client.in.readLine();
        } while (!requestLine.trim().equals(""));

        qod = client.in.readLine();
        System.out.println(qod);
        Gson gson = new Gson();
        Server.quoteOfTheDay = gson.fromJson(qod, QuoteOfTheDay.class);
        System.out.println(Server.quoteOfTheDay);

    }
}
