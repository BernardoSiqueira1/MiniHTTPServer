package Components.ServerObjects;

import Components.ServerObjects.Request.RequestBody;
import Components.ServerObjects.Request.RequestHeaders;
import Components.ServerObjects.Request.RequestLine;

import java.util.HashMap;

public class ClientRequestObject {

    public RequestLine requestLine;
    public RequestHeaders requestHeaders;
    public RequestBody requestBody;

    public ClientRequestObject(RequestLine requestLine, RequestHeaders requestHeaders, RequestBody requestBody) {
        this.requestBody = requestBody;
        this.requestHeaders = requestHeaders;
        this.requestLine = requestLine;
    }

}
