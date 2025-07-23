package endpointhandler;

import server.model.request.ClientRequestObject;
import server.model.response.ClientResponseObject;
import server.model.response.ResponseBody;
import server.model.response.ResponseHeaders;
import server.model.response.ResponseLine;

import java.util.HashMap;

public class DefaultNotFoundHandler {

    public static ClientResponseObject endpointNotFound(ClientRequestObject clientRequestObject) {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "text/html");


        ResponseLine responseLine = new ResponseLine(404, "NOT FOUND", "HTTP/1.1");
        ResponseHeaders responseHeaders = new ResponseHeaders(headers);
        ResponseBody responseBody = new ResponseBody("<body><h2>404 - Requested endpoint not found.</h2></body>");

        return new ClientResponseObject(responseLine,responseHeaders,responseBody);
    }

}
