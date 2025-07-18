package server;

import server.configuration.HandlerChainConfiguration;
import server.httpchain.HTTPHandlerChain;
import server.service.ServiceDispatcherConfiguration;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public final class Server extends ServerSocket {

    private HandlerChainConfiguration handlerChainConfiguration;
    private ServiceDispatcherConfiguration serviceDispatcherConfiguration;
    private final int applicationPort;

    public Server(int applicationPort) throws IOException {
        super(applicationPort);
        this.applicationPort = applicationPort;
    }

    public void setHandlerChainConfiguration(HandlerChainConfiguration handlerChainConfiguration){
        this.handlerChainConfiguration = handlerChainConfiguration;
    }

    public void setServiceDispatcher(ServiceDispatcherConfiguration serviceDispatcherConfiguration){
        this.serviceDispatcherConfiguration = serviceDispatcherConfiguration;
    }

    public void listen() {
        System.out.println(String.format("Starting server at port %d", applicationPort));

        while (true) {

            try {
                Socket clientConnection = this.accept();
                new Thread(new HTTPHandlerChain(handlerChainConfiguration, serviceDispatcherConfiguration, clientConnection)).start();
            }

            catch (IOException ioException){
                System.out.println("Falha na conexão");
            }

        }
    }

}
