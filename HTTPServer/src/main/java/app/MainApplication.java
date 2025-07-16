package app;

import server.configuration.HandlerChainConfiguration;
import server.configuration.DefaultHandlerChainConfiguration;
import server.Server;

import java.io.IOException;

public class MainApplication {

    public static void main(String[] args) throws IOException {
        HandlerChainConfiguration httpChainConfiguration = DefaultHandlerChainConfiguration.getDefaultChainConfiguration();
        Server HTTPApp = new Server(8080);
        HTTPApp.setHandlerChainConfiguration(httpChainConfiguration);
        HTTPApp.setServiceDispatcher(null);

        HTTPApp.listen();
    }

}
