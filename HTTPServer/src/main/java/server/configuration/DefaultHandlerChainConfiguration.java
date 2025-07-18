    package server.configuration;

    import server.filterhandlers.RequestHandler;
    import server.filterhandlers.VerifyRequestObjectHandler;

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
                new VerifyRequestObjectHandler()
            );
        }


    }
