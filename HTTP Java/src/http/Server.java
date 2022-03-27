package http;


import app.QuoteOfTheDay;
import app.Quotes;
import service.json.Service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {

    public static final int TCP_PORT = 8080;
    public static CopyOnWriteArrayList<Quotes> sviQuotes = new CopyOnWriteArrayList<>();
    public static QuoteOfTheDay quoteOfTheDay;
    public static void main(String[] args) throws IOException {

        try {
            ServerSocket ss = new ServerSocket(TCP_PORT);
            while (true) {
                Socket sock = ss.accept();
                new Thread(new ServerThread(sock)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
