package server;

import server.configuration.HandlerChainConfiguration;
import server.httpchain.HTTPHandlerChain;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends ServerSocket {

    private final HandlerChainConfiguration handlerChainConfiguration;

    public Server(int applicationPort, HandlerChainConfiguration httpHandlerChainConfiguration) throws IOException {
        super(applicationPort);
        this.handlerChainConfiguration = httpHandlerChainConfiguration;
    }

    public void listen() {
        while (true) {

            try {
                Socket clientConnection = this.accept();
                new Thread(new HTTPHandlerChain(handlerChainConfiguration, clientConnection)).start();
            }

            catch (IOException ioException){
                System.out.println("Falha na conexão");
            }

        }
    }

    public void addEndpoint(String endpoint, String method, Runnable executionMethod){
        // return random bullshit
    }

}
