package app;

import server.configuration.ChainConfiguration;
import server.configuration.DefaultChainConfiguration;
import server.Server;

import java.io.IOException;

public class MainApplication {

    public static void main(String[] args) throws IOException {
        ChainConfiguration httpChainConfiguration = DefaultChainConfiguration.getDefaultChainConfiguration();

        Server HTTPApp = new Server(8080, httpChainConfiguration);
        HTTPApp.listen();

    }

}
