package app;

import server.configuration.HandlerChainConfiguration;
import server.configuration.DefaultHandlerChainConfiguration;
import server.Server;

import java.io.IOException;

public class MainApplication {

        public static void main(String[] args) throws IOException {

            HandlerChainConfiguration handlerChainConfiguration = DefaultHandlerChainConfiguration.getDefaultChainConfiguration();

            Server server = new Server(8080);

            server.listen();
        }

}
