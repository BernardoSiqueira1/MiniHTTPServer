package application;

import configuration.EndpointRouterConfiguration;
import endpointhandler.GetMessageHandler;
import router.ApplicationEndpointRouter;
import server.Server;
import server.service.ThirdPartyDispatcher;

import java.io.IOException;


public class Application {

    public static void main(String[] args) throws IOException {

        EndpointRouterConfiguration endpointRouterConfiguration = new EndpointRouterConfiguration();
        endpointRouterConfiguration.setNewEndpoint("/getMessage", GetMessageHandler::getMessageEndpoint);

        ApplicationEndpointRouter endpointRouter = new ApplicationEndpointRouter(endpointRouterConfiguration);
        ThirdPartyDispatcher.setThirdPartyService(endpointRouter);

        Server httpServer = new Server(8081);

        httpServer.listen();

        System.out.println("Aplicação iniciada.");
    }


}
