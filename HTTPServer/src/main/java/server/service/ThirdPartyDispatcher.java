package server.service;

import server.exceptions.ThirdPartyServiceNotSetup;
import server.model.request.ClientRequestObject;
import server.model.response.ClientResponseObject;

public final class ThirdPartyDispatcher {

    private static ThirdPartyService thirdPartyService;

    public static void setThirdPartyService(ThirdPartyService customThirdPartyService) {
        thirdPartyService = customThirdPartyService;
    }

    public static ClientResponseObject callService(ClientRequestObject clientRequestObject) {

        try {
            return thirdPartyService.execute(clientRequestObject);
        }

        catch (NullPointerException exception) { // Service was not set up
            throw new ThirdPartyServiceNotSetup();
        }

    }

}
