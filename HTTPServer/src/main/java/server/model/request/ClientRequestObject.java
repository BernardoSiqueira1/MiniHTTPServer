package server.model.request;

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
