    package server.configuration;

    import server.handler.Default.LogActivityHandler;
    import server.handler.RequestHandler;

    public class DefaultChainConfiguration extends ChainConfiguration {
        /**
         * <p>
         * Provides a default http process chain to deal with client requests
         * </p>
         * **/

        private DefaultChainConfiguration(RequestHandler... requestHandlers) {
            super(requestHandlers);
        }

        public static DefaultChainConfiguration getDefaultChainConfiguration(){
            return new DefaultChainConfiguration(
                    new LogActivityHandler()
            );
        }


    }
