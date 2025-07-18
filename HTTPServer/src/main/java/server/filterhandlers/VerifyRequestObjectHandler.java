package server.filterhandlers;

import server.model.request.ClientRequestObject;

public final class VerifyRequestObjectHandler implements RequestHandler {

    @Override
    public void handleRequest(ClientRequestObject clientRequestObject) {
        System.out.println(clientRequestObject.requestLine().method());
        System.out.println(clientRequestObject.requestLine().clearPath());
        System.out.println(clientRequestObject.requestBody().requestBody());
    }

}
