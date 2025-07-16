    package server.configuration;

    import server.filterhandlers.LogActivityHandler;
    import server.filterhandlers.RequestHandler;

    public final class DefaultHandlerChainConfiguration extends HandlerChainConfiguration {

        /**
         * <p>
         * Provides a default http process chain to deal with client requests
         * </p>
         * **/

        private DefaultHandlerChainConfiguration(RequestHandler... requestHandlers) {
            super(requestHandlers);
        }

        public static DefaultHandlerChainConfiguration getDefaultChainConfiguration(){
            return new DefaultHandlerChainConfiguration(
                    new LogActivityHandler(),
                    new LogActivityHandler(),
                    new LogActivityHandler()
            );
        }


    }
