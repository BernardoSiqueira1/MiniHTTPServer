package server.handler;

import server.model.request.ClientRequestObject;

public interface RequestHandler {

    public void handleClientRequest(ClientRequestObject clientRequestObject);

}
