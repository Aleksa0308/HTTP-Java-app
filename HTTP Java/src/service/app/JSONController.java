package service.app;


import service.json.Request;
import service.json.response.JSONresponse;
import service.json.response.Response;

public class JSONController extends Controller{

    public JSONController(Request request) {
        super(request);
    }
    String qod;
    @Override
    public Response doGet() {
        String content = " ";
        content += " ";

        return new JSONresponse(content);
    }

    @Override
    public Response doPost() {
        return null;
    }
}
