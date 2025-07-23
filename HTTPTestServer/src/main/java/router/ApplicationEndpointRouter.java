package router;

import configuration.EndpointRouterConfiguration;
import endpointhandler.DefaultNotFoundHandler;
import server.model.request.ClientRequestObject;
import server.model.response.ClientResponseObject;
import server.service.ThirdPartyService;

import java.util.function.Function;

public final class ApplicationEndpointRouter implements ThirdPartyService {

    private EndpointRouterConfiguration endpointRouterConfiguration;

    public ApplicationEndpointRouter(EndpointRouterConfiguration endpointRouterConfiguration){
        this.endpointRouterConfiguration = endpointRouterConfiguration;
    }

    @Override
    public ClientResponseObject execute(ClientRequestObject clientRequestObject) {

        // System.out.println(clientRequestObject.requestLine().fullPath());
        
        String clearPath = clientRequestObject.requestLine().clearPath();
        Function<ClientRequestObject, ClientResponseObject> routeHandler = endpointRouterConfiguration
                .getEndpointRoutes()
                .get(clearPath);

        if (routeHandler != null){
            return routeHandler.apply(clientRequestObject);
        }

        else {
            return DefaultNotFoundHandler.endpointNotFound(clientRequestObject);
        }

    }
}
