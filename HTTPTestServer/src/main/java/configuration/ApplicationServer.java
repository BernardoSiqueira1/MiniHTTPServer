package configuration;

import server.Server;
import server.configuration.DefaultHandlerChainConfiguration;
import server.configuration.HandlerChainConfiguration;
import server.service.DispatcherService;
import server.service.ServiceDispatcherConfiguration;

import java.io.IOException;

public final class ApplicationServer {

    public static Server getServer(DispatcherService applicationService) throws IOException {
        HandlerChainConfiguration httpHandlerChain = DefaultHandlerChainConfiguration.getDefaultChainConfiguration();

        ServiceDispatcherConfiguration requestServiceDispatcher = new ServiceDispatcherConfiguration(applicationService);

        Server httpServer = new Server(8081);

        httpServer.setServiceDispatcher(requestServiceDispatcher);
        httpServer.setHandlerChainConfiguration(httpHandlerChain);
        return httpServer;
    }

}
