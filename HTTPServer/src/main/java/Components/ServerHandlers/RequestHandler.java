package Components.ServerHandlers;

import Components.ServerObjects.ClientRequestObject;

public interface RequestHandler {

    public void handleClientRequest(ClientRequestObject clientRequestObject);

}
