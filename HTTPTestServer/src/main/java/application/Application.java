package application;

import configuration.EndpointRouterConfiguration;
import endpointhandler.GetMessageHandler;
import router.ApplicationEndpointRouter;
import server.Server;

import java.io.IOException;

import static configuration.ApplicationServer.getServer;

public class Application {

    public static void main(String[] args) throws IOException {

        EndpointRouterConfiguration endpointRouterConfiguration = new EndpointRouterConfiguration();
        endpointRouterConfiguration.setNewEndpoint("/getMessage", GetMessageHandler::getMessageEndpoint);

        ApplicationEndpointRouter endpointRouter = new ApplicationEndpointRouter(endpointRouterConfiguration);

        Server httpServer = getServer(endpointRouter);
        httpServer.listen();

        System.out.println("Aplicação iniciada.");
    }


}
