package Server;

import HTTPHandlers.ConfigClasses.ChainConfiguration;
import HTTPHandlers.HTTPHandlerChain;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Application extends ServerSocket {

    private ChainConfiguration chainConfiguration;

    public Application(int applicationPort) throws IOException {
        super(applicationPort);
    }

    public void listen() {
        while (true) {

            try {
                Socket clientConnection = this.accept();
                Thread newClientThread = new Thread(new HTTPHandlerChain(chainConfiguration, clientConnection));
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
