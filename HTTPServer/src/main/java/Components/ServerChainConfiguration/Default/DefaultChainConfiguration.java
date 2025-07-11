    package Components.ServerChainConfiguration.Default;

    import Components.ServerChainConfiguration.ChainConfiguration;
    import Components.ServerHandlers.Default.LogActivityHandler;
    import Components.ServerHandlers.RequestHandler;

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
