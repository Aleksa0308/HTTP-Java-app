package service.json;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Service {

    public static final int Service_PORT = 8081;

    public static void main(String[] args) {

        try {
            ServerSocket ss = new ServerSocket(Service_PORT);
            while (true) {
                Socket sock = ss.accept();
                new Thread(new ServiceThread(sock)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
