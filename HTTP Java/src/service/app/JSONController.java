package service.app;


import com.google.gson.Gson;
import service.json.Qod;
import service.json.Request;
import service.json.Service;
import service.json.response.JSONresponse;
import service.json.response.Response;

import java.util.Random;

public class JSONController extends Controller{

    public JSONController(Request request) {
        super(request);
    }
    Qod qod;
    String jsonAns;
    @Override
    public Response doGet() {
        Gson gson = new Gson();
        Random random = new Random();
        qod = Service.quoteOfTheDay.get(random.nextInt(7));
        jsonAns = gson.toJson(qod);
        System.out.println(qod);

        return new JSONresponse(jsonAns);
    }

    @Override
    public Response doPost() {
        return null;
    }
}
