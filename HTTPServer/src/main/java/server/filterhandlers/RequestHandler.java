package server.filterhandlers;

import server.model.request.ClientRequestObject;

public interface RequestHandler {

    public void handleRequest(ClientRequestObject clientRequestObject);

}
