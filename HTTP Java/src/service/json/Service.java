package service.json;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

public class Service {

    public static final int Service_PORT = 8081;
    public static CopyOnWriteArrayList<Qod> quoteOfTheDay = new CopyOnWriteArrayList<Qod>();
    public static void main(String[] args) {
        makeQuotes();
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
    public static void makeQuotes(){
        Qod qod = new Qod("Lao Tzu","The journey of a thousand miles begins with one step.");
        Qod qod1 = new Qod("Kanye West", "I need a room full of mirrors, so I can be surrounded by winners!");
        Qod qod2 = new Qod("School Kid", "I don't care that you broke your elbow!");
        Qod qod3 = new Qod("Will Farrel", "Before you marry a person, you should first make them use a computer with slow Internet to see who they really are.");
        Qod qod4 = new Qod("Michael Scott","That's what she said!");
        Qod qod5 = new Qod("Tony Stark","I am Iron-Man");
        Qod qod6 = new Qod("Kanye West","You may be talented, but you’re not Kanye West.");
        quoteOfTheDay.add(qod);
        quoteOfTheDay.add(qod1);
        quoteOfTheDay.add(qod2);
        quoteOfTheDay.add(qod3);
        quoteOfTheDay.add(qod4);
        quoteOfTheDay.add(qod5);
        quoteOfTheDay.add(qod6);
    }
}
