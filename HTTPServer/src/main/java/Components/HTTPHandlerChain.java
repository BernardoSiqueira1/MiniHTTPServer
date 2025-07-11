package Components;

import Components.ServerParsers.RequestParser;
import Components.ServerChainConfiguration.ChainConfiguration;
import Components.ServerHandlers.RequestHandler;
import Components.ServerObjects.ClientRequestObject;

import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class HTTPHandlerChain implements Runnable{

    private final Socket clientConnection;
    private final RequestParser requestParser = new RequestParser();
    private final List<RequestHandler> httpHandlersList;

    public HTTPHandlerChain(ChainConfiguration chainConfiguration, Socket clientConnection){
        this.clientConnection = clientConnection;
        this.httpHandlersList = chainConfiguration.getRequestHandlerList();
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
