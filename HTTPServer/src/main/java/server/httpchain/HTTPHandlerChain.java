package server.httpchain;

import server.model.response.ClientResponseObject;
import server.configuration.HandlerChainConfiguration;
import server.handler.RequestHandler;
import server.model.request.ClientRequestObject;
import server.parser.request.RequestParser;
import server.parser.response.ResponseFormatter;

import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class HTTPHandlerChain implements Runnable {

    private final Socket clientConnection;
    private final RequestParser requestParser = new RequestParser();
    private final ResponseFormatter responseFormatter = new ResponseFormatter();
    private final List<RequestHandler> httpHandlersList;

    public HTTPHandlerChain(HandlerChainConfiguration HandlerChainConfiguration, Socket clientConnection){
        this.clientConnection = clientConnection;
        this.httpHandlersList = HandlerChainConfiguration.getRequestHandlerList();
    }

    @Override
    public void run() {

        try {
            ClientRequestObject clientRequestObject = requestParser.parse(clientConnection.getInputStream());
            ClientResponseObject clientResponseObject = null;

            for (RequestHandler handler: httpHandlersList){
                handler.handleRequest(clientRequestObject, clientResponseObject);
            }


        }
        catch (IOException ioException){
            System.out.println(ioException.getMessage());
        }

    }

}
