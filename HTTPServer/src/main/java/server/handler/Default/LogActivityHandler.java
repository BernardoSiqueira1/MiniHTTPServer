package server.handler.Default;

import server.handler.RequestHandler;
import server.model.request.ClientRequestObject;

public class LogActivityHandler implements RequestHandler {
    @Override
    public void handleClientRequest(ClientRequestObject clientRequestObject) {
        System.out.println("Passou por aqui, só para testar por enquanto.");
    }
}
