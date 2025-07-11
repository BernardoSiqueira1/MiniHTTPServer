package Components.ServerHandlers.Default;

import Components.ServerHandlers.RequestHandler;
import Components.ServerObjects.ClientRequestObject;

public class LogActivityHandler implements RequestHandler {
    @Override
    public void handleClientRequest(ClientRequestObject clientRequestObject) {
        System.out.println("Passou por aqui, só para testar por enquanto.");
    }
}
