package server.service;

import server.model.request.ClientRequestObject;
import server.model.response.ClientResponseObject;

public interface ThirdPartyService {

    public ClientResponseObject execute(ClientRequestObject clientRequestObject);

}
