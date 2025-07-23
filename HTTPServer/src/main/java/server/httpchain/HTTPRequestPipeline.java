package server.httpchain;

import server.logging.ServerLog;
import server.iohandlers.response.ResponseSender;
import server.iohandlers.response.ResponseSerializer;
import server.model.response.ClientResponseObject;
import server.model.request.ClientRequestObject;
import server.iohandlers.request.RequestParser;
import server.service.ThirdPartyDispatcher;

import java.net.Socket;

public final class HTTPRequestPipeline implements Runnable {

    private final Socket clientConnection;
    // private final List<RequestHandler> httpHandlersList; // Deactivated until i find a way to refactor this.

    public HTTPRequestPipeline(Socket clientConnection){
        this.clientConnection = clientConnection;
    }

    @Override
    public void run() {

        ClientRequestObject clientRequestObject = null;
        ClientResponseObject clientResponseObject = null;
        String serializedResponse = "";

        try {

            clientRequestObject = RequestParser.parse(clientConnection.getInputStream());
            clientResponseObject = ThirdPartyDispatcher.callService(clientRequestObject);

            serializedResponse = ResponseSerializer.serialize(clientResponseObject);
            ResponseSender.sendToClient(clientConnection, serializedResponse);

            clientConnection.close();

        }
        catch (Exception exception) {
            ServerLog.log(exception.getMessage());
        }

    }

}
