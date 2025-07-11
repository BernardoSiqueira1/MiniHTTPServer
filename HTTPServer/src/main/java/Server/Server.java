package Server;

import Components.ServerChainConfiguration.ChainConfiguration;
import Components.HTTPHandlerChain;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends ServerSocket {

    private final ChainConfiguration chainConfiguration;

    public Server(int applicationPort, ChainConfiguration httpHandlerChainConfiguration) throws IOException {
        super(applicationPort);
        this.chainConfiguration = httpHandlerChainConfiguration;
    }

    public void listen() {
        while (true) {

            try {
                Socket clientConnection = this.accept();
                new Thread(new HTTPHandlerChain(chainConfiguration, clientConnection)).start();
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
