    package server.configuration;

    import server.handler.DispatchServiceHandler;
    import server.handler.LogActivityHandler;
    import server.handler.RequestHandler;

    public class DefaultHandlerChainConfiguration extends HandlerChainConfiguration {
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
                    new DispatchServiceHandler()
            );
        }


    }
