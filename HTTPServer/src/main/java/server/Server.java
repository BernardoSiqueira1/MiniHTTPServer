package server;

import server.configuration.HandlerChainConfiguration;
import server.httpchain.HTTPRequestPipeline;
import server.service.ThirdPartyDispatcher;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public final class Server extends ServerSocket {

    // private HandlerChainConfiguration handlerChainConfiguration;
    private final int applicationPort;

    public Server(int applicationPort) throws IOException {
        super(applicationPort);
        this.applicationPort = applicationPort;
    }

    //public void setHandlerChainConfiguration(HandlerChainConfiguration handlerChainConfiguration){
    //    this.handlerChainConfiguration = handlerChainConfiguration;
    //}

    public void listen() {
        System.out.println(String.format("Starting server at port %d", applicationPort));

        while (true) {

            try {
                Socket clientConnection = this.accept();

                new Thread(new HTTPRequestPipeline(clientConnection)).start();
            }

            catch (IOException ioException){
                System.out.println("Falha na conexão");
            }

        }
    }

}
