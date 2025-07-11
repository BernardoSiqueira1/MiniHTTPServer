package Application;

import Components.ServerChainConfiguration.ChainConfiguration;
import Components.ServerChainConfiguration.Default.DefaultChainConfiguration;
import Server.Server;

import java.io.IOException;

public class MainApplication {

    public static void main(String[] args) throws IOException {
        ChainConfiguration httpChainConfiguration = DefaultChainConfiguration.getDefaultChainConfiguration();

        Server HTTPApp = new Server(8080, httpChainConfiguration);
        HTTPApp.listen();

    }

}
