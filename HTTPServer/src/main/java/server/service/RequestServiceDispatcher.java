package server.service;

import server.model.request.ClientRequestObject;
import server.model.response.ClientResponseObject;

public final class RequestServiceDispatcher {

    private final DispatcherService dispatcherService;

    public RequestServiceDispatcher(DispatcherService dispatcherService) {
        this.dispatcherService = dispatcherService;
    }

    public void dispatch(ClientRequestObject clientRequestObject, ClientResponseObject clientResponseObject) {
        dispatcherService.execute();
    }

}
