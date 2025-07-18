package server.httpchain;

import server.iohandlers.response.ResponseSender;
import server.iohandlers.response.ResponseSerializer;
import server.model.response.ClientResponseObject;
import server.configuration.HandlerChainConfiguration;
import server.filterhandlers.RequestHandler;
import server.model.request.ClientRequestObject;
import server.iohandlers.request.RequestParser;
import server.service.ServiceDispatcherConfiguration;

import java.io.IOException;
import java.net.Socket;
import java.util.List;

public final class HTTPHandlerChain implements Runnable {

    private final Socket clientConnection;
    private final ServiceDispatcherConfiguration serviceDispatcher;
    private final List<RequestHandler> httpHandlersList;

    public HTTPHandlerChain(HandlerChainConfiguration HandlerChainConfiguration, ServiceDispatcherConfiguration serviceDispatcherConfiguration, Socket clientConnection){
        this.clientConnection = clientConnection;
        this.httpHandlersList = HandlerChainConfiguration.getRequestHandlerList();
        this.serviceDispatcher = serviceDispatcherConfiguration;
    }

    @Override
    public void run() {

        ClientRequestObject clientRequestObject = null;
        ClientResponseObject clientResponseObject = null;
        String serializedResponse = "";

        try {

            clientRequestObject = RequestParser.parse(clientConnection.getInputStream());

            for (RequestHandler handler: httpHandlersList){
                handler.handleRequest(clientRequestObject);
            }

            clientResponseObject = serviceDispatcher.dispatch(clientRequestObject);
            serializedResponse = ResponseSerializer.format(clientResponseObject);

            ResponseSender.sendToClient(clientConnection, serializedResponse);

        }

        catch (IOException ioException){

            System.out.println(ioException.getMessage());

        }

    }

}
