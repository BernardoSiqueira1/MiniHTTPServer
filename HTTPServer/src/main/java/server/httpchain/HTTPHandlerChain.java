package server.httpchain;

import server.iohandlers.response.ResponseSerializer;
import server.model.response.ClientResponseObject;
import server.configuration.HandlerChainConfiguration;
import server.filterhandlers.RequestHandler;
import server.model.request.ClientRequestObject;
import server.iohandlers.request.RequestParser;
import server.service.RequestServiceDispatcher;

import java.io.IOException;
import java.net.Socket;
import java.util.List;

public final class HTTPHandlerChain implements Runnable {

    private final Socket clientConnection;
    private final RequestServiceDispatcher serviceDispatcher;
    private final List<RequestHandler> httpHandlersList;

    public HTTPHandlerChain(HandlerChainConfiguration HandlerChainConfiguration, RequestServiceDispatcher requestServiceDispatcher, Socket clientConnection){
        this.clientConnection = clientConnection;
        this.httpHandlersList = HandlerChainConfiguration.getRequestHandlerList();
        this.serviceDispatcher = requestServiceDispatcher;
    }

    @Override
    public void run() {

        ClientRequestObject clientRequestObject = null;
        ClientResponseObject clientResponseObject = null;

        try {

            RequestParser.parse(clientConnection.getInputStream());

            for (RequestHandler handler: httpHandlersList){
                handler.handleRequest(clientRequestObject);
            }

            serviceDispatcher.dispatch(clientRequestObject, clientResponseObject);
            ResponseSerializer.format(clientResponseObject);

        }
        catch (IOException ioException){
            System.out.println(ioException.getMessage());
        }

    }

}
