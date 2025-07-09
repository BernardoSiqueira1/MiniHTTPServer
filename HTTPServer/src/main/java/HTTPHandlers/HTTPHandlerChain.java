package HTTPHandlers;

import HTTPHandlers.ConfigClasses.ChainConfiguration;
import HTTPHandlers.DefaultHandlers.DefaultHandler;
import HTTPHandlers.DefaultHandlers.ServerParser;

import java.net.Socket;
import java.util.List;

public class HTTPHandlerChain implements Runnable{

    private final Socket clientConnection;
    private final ServerParser serverParser = new ServerParser();
    private final List<DefaultHandler> httpDefaultHandlers;

    public HTTPHandlerChain(ChainConfiguration chainConfiguration, Socket clientConnection){
        this.clientConnection = clientConnection;
        this.httpDefaultHandlers = chainConfiguration.getDefaultHandlerList;
    }

    @Override
    public void run() {

    }

}
