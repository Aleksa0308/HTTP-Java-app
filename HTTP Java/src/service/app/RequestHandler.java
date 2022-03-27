package service.app;

import http.HttpMethod;
import service.json.Request;
import service.json.response.Response;

public class RequestHandler {
    public Response handle(Request request) throws Exception{
        if(request.getPath().equals("/qod") && request.getHttpMethod().equals(HttpMethod.GET)) {
            return (new JSONController(request)).doGet();
        }
        throw new Exception("Page: " + request.getPath() + ". Method: " + request.getHttpMethod() + " not found!");
    }

}
