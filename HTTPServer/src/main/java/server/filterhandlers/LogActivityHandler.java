package server.filterhandlers;

import server.model.request.ClientRequestObject;

public final class LogActivityHandler implements RequestHandler {

    @Override
    public void handleRequest(ClientRequestObject clientRequestObject) {
        System.out.println("Passou por aqui, só para testar por enquanto.");
    }

}
