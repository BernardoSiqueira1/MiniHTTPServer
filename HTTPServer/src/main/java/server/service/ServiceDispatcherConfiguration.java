package server.service;

import server.model.request.ClientRequestObject;
import server.model.response.ClientResponseObject;

public final class ServiceDispatcherConfiguration {

    private final DispatcherService dispatcherService;

    public ServiceDispatcherConfiguration(DispatcherService dispatcherService) {
        this.dispatcherService = dispatcherService;
    }

    public ClientResponseObject dispatch(ClientRequestObject clientRequestObject) {
        return dispatcherService.execute(clientRequestObject);
    }

}
