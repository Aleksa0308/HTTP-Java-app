package app;

import http.Request;
import http.response.HtmlResponse;
import http.response.RederictResponse;
import http.response.Response;

public class QuotesController extends Controller {

    public QuotesController(Request request) {
        super(request);
    }
    String htmlBody;
    @Override
    public Response doGet() {
        String style = "" + "input[type=text], select {\n" +
                "      width: 100%;\n" +
                "      padding: 12px 20px;\n" +
                "      margin: 8px 0;\n" +
                "      display: inline-block;\n" +
                "      border: 1px solid #ccc;\n" +
                "      border-radius: 4px;\n" +
                "      box-sizing: border-box;\n" +
                "    }\n" +
                "    \n" +
                "    input[type=submit] {\n" +
                "      width: 100%;\n" +
                "      background-color: rgb(19, 141, 255);\n" +
                "      color: white;\n" +
                "      padding: 14px 20px;\n" +
                "      margin: 8px 0;\n" +
                "      border: none;\n" +
                "      border-radius: 4px;\n" +
                "      cursor: pointer;\n" +
                "    }\n" +
                "    \n" +
                "    input[type=submit]:hover {\n" +
                "      background-color: rgb(44, 153, 255);\n" +
                "    }\n" +
                "    \n" +
                "    div {\n" +
                "      border-radius: 5px;\n" +
                "      background-color: #f2f2f2;\n" +
                "      padding: 20px;\n" +
                "    }\n" +
                "    label{\n" +
                "        text-align: left;\n" +
                "    }";
        htmlBody = "" +
                "<form method=\"POST\" action=\"/save-quote\">" +
                "<label>Author: </label><br><input name=\"author\", type=\"text\", placeholder=\"Author\"><br><br>" +
                "<label>Quote:</label>" +
                "<br>\n" +
                "<input name=\"quote\", type=\"text\", placeholder=\"Quote\">" +
                "<input type=\"submit\" value=\"Submit\">" +
                "</form>"
                + "<br>";

        String content = "<html><head><title>Daily Quotes</title></head>\n" + "<style>" + style + "</style>";
        content += "<body style=\"margin: auto; width: 20%; padding: 10px;\">" + htmlBody + "</body></html>";

        return new HtmlResponse(content);
    }

    @Override
    public Response doPost() {
        // TODO: obradi POST zahtev
        return new RederictResponse("/quotes");
    }
}
