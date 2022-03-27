package service.json.response;

public class JSONresponse extends Response {
    String qod;

    public JSONresponse(String qod) {
        this.qod = qod;
    }

    @Override
    public String GetResponseString() {
        String response = "HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n";
        response += qod;

        return response;
    }
}
