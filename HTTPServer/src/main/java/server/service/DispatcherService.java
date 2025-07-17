package server.service;

import server.model.request.ClientRequestObject;
import server.model.response.ClientResponseObject;

public interface DispatcherService {

    public ClientResponseObject execute(ClientRequestObject clientRequestObject, ClientResponseObject clientResponseObject);

}
