package server.handler;

import server.configuration.DispatcherConfiguration;
import server.model.request.ClientRequestObject;
import server.model.response.ClientResponseObject;
import server.service.DispatcherService;

public final class DispatchServiceHandler implements RequestHandler {

    private DispatcherConfiguration serviceProviderConfiguration;

    @Override
    public void handleRequest(ClientRequestObject clientRequestObject, ClientResponseObject clientResponseObject) {
        serviceProviderConfiguration
                .getService()
                .execute();
    }

}
