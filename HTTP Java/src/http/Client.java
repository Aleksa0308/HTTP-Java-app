package http;

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
        //TODO: Kreirati Klijenta koji ce da salje GET zahtev ka Pomocnom Servisu
        // Razmisli kakav response treba da bude od pomocnog servisa, da li treba da redirektuje ili nesto drugacije
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



    }
}
