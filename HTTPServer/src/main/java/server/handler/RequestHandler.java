package server.handler;

import server.model.request.ClientRequestObject;
import server.model.response.ClientResponseObject;

public interface RequestHandler {

    public void handleRequest(ClientRequestObject clientRequestObject, ClientResponseObject clientResponseObject);

}
