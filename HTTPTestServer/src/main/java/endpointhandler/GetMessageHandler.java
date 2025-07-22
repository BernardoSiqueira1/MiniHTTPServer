package endpointhandler;

import server.model.request.ClientRequestObject;
import server.model.response.ClientResponseObject;
import server.model.response.ResponseBody;
import server.model.response.ResponseHeaders;
import server.model.response.ResponseLine;

import java.util.HashMap;

public class GetMessageHandler{

    public static ClientResponseObject getMessageEndpoint(ClientRequestObject clientRequestObject) {

        String responseString = "Olá usuário, isso é um teste.";
        String responseLenght = String.valueOf(responseString.length());

        HashMap<String, String> responseHeadersMap = new HashMap<>();
        responseHeadersMap.put("Content-Type","text/plain");
        responseHeadersMap.put("Connection","close");
        responseHeadersMap.put("Content-Length", responseLenght);

        ResponseLine responseLine = new ResponseLine(200, "OK", "HTTP/1.1");
        ResponseHeaders responseHeaders = new ResponseHeaders(responseHeadersMap);
        ResponseBody responseBody = new ResponseBody(responseString);

        return new ClientResponseObject(responseLine,responseHeaders,responseBody);
    }

}
