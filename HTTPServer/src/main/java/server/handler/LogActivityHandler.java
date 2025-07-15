package server.handler;

import server.model.request.ClientRequestObject;
import server.model.response.ClientResponseObject;

public final class LogActivityHandler implements RequestHandler {

    @Override
    public void handleRequest(ClientRequestObject clientRequestObject, ClientResponseObject clientResponseObject) {
        System.out.println("Passou por aqui, só para testar por enquanto.");
    }

}
