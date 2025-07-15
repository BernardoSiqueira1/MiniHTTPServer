package server.model.request;

public final record ClientRequestObject(
            RequestLine requestLine,
            RequestHeaders requestHeaders,
            RequestBody requestBody
        )
{}