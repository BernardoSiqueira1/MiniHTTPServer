package server.httpchain;

import server.parser.RequestParser;
import server.configuration.ChainConfiguration;
import server.handler.RequestHandler;
import server.model.request.ClientRequestObject;

import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class DefaultHTTPHandlerChain implements HTTPHandlerChain {

    private final Socket clientConnection;
    private final RequestParser requestParser = new RequestParser();
    private final List<RequestHandler> httpHandlersList;

    public DefaultHTTPHandlerChain(ChainConfiguration defaultChainConfiguration, Socket clientConnection){
        this.clientConnection = clientConnection;
        this.httpHandlersList = defaultChainConfiguration.getRequestHandlerList();
    }

    @Override
    public void run() {

        try {
            ClientRequestObject clientRequestObject = requestParser.parse(clientConnection.getInputStream());

            for (RequestHandler handler: httpHandlersList){
                handler.handleClientRequest(clientRequestObject);
            }

            //TODO - Implementar encaminhamento para algum serviço externo e retorno para o cliente
        }
        catch (IOException ioException){
            System.out.println(ioException.getMessage());
        }

    }

}
