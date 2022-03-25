package http.response;

public class RederictResponse extends Response{
    private String location;

    public RederictResponse(String location) {
        this.location = location;
    }

    @Override
    public String getResponseString() {
        String response = "HTTP/1.1 301 OK\r\nLocation: " + location + "\r\n\r\n";
        return response;
    }
}
