package service.app;


import com.google.gson.Gson;
import service.json.Qod;
import service.json.Request;
import service.json.Service;
import service.json.response.JSONresponse;
import service.json.response.Response;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Random;

public class JSONController extends Controller{

    public JSONController(Request request) {
        super(request);
    }
    Qod qod;
    String jsonAns;
    @Override
    public Response doGet() {
        return new JSONresponse(getDateQuote());
        //return new JSONresponse(getRandomQuote());
    }

    @Override
    public Response doPost() {
        return null;
    }

    private String getRandomQuote(){
        Gson gson = new Gson();
        Random random = new Random();
        qod = Service.quoteOfTheDay.get(random.nextInt(7));
        jsonAns = gson.toJson(qod);
        System.out.println(qod);

        return jsonAns;
    }
    private String getDateQuote(){
        Gson gson = new Gson();

        LocalDate localDate = LocalDate.now();
        DayOfWeek day = localDate.getDayOfWeek();
        int weekday = day.getValue();
        if(weekday == 1){
            qod = Service.quoteOfTheDay.get(0);
            jsonAns = gson.toJson(qod);
            System.out.println(qod);
        }else if(weekday == 2){
            qod = Service.quoteOfTheDay.get(1);
            jsonAns = gson.toJson(qod);
            System.out.println(qod);
        }else if(weekday == 3) {
            qod = Service.quoteOfTheDay.get(2);
            jsonAns = gson.toJson(qod);
            System.out.println(qod);
        }else if(weekday == 4) {
            qod = Service.quoteOfTheDay.get(3);
            jsonAns = gson.toJson(qod);
            System.out.println(qod);
        }
        else if(weekday == 5) {
            qod = Service.quoteOfTheDay.get(4);
            jsonAns = gson.toJson(qod);
            System.out.println(qod);
        }else if(weekday == 6) {
            qod = Service.quoteOfTheDay.get(5);
            jsonAns = gson.toJson(qod);
            System.out.println(qod);
        }else if(weekday == 7) {
            qod = Service.quoteOfTheDay.get(6);
            jsonAns = gson.toJson(qod);
            System.out.println(qod);
        }
        return jsonAns;
    }
}
