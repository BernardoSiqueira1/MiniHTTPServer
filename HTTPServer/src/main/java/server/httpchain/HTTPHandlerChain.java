package server.httpchain;

import server.model.response.ClientResponseObject;
import server.configuration.HandlerChainConfiguration;
import server.filterhandlers.RequestHandler;
import server.model.request.ClientRequestObject;
import server.iohandlers.request.RequestParser;
import server.iohandlers.response.ResponseFormatter;
import server.service.RequestServiceDispatcher;

import java.io.IOException;
import java.net.Socket;
import java.util.List;

public final class HTTPHandlerChain implements Runnable {

    private final Socket clientConnection;
    private final RequestParser requestParser = new RequestParser();
    private final ResponseFormatter responseFormatter = new ResponseFormatter();
    private final RequestServiceDispatcher serviceDispatcher;
    private final List<RequestHandler> httpHandlersList;

    public HTTPHandlerChain(HandlerChainConfiguration HandlerChainConfiguration, RequestServiceDispatcher requestServiceDispatcher, Socket clientConnection){
        this.clientConnection = clientConnection;
        this.httpHandlersList = HandlerChainConfiguration.getRequestHandlerList();
        this.serviceDispatcher = requestServiceDispatcher;
    }

    @Override
    public void run() {

        try {

            ClientRequestObject clientRequestObject = requestParser.parse(clientConnection.getInputStream());
            ClientResponseObject clientResponseObject = null;

            for (RequestHandler handler: httpHandlersList){
                handler.handleRequest(clientRequestObject);
            }

            serviceDispatcher.dispatch(clientRequestObject, clientResponseObject);
            ResponseFormatter.format(clientResponseObject);

        }
        catch (IOException ioException){
            System.out.println(ioException.getMessage());
        }

    }

}
