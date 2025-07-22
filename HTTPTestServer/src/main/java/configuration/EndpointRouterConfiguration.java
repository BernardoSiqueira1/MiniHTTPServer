package configuration;

import server.model.request.ClientRequestObject;
import server.model.response.ClientResponseObject;

import java.util.HashMap;
import java.util.function.Function;

public final class EndpointRouterConfiguration {

    private HashMap<String, Function<ClientRequestObject, ClientResponseObject>> endpointRoutes = new HashMap<>();

    public HashMap<String, Function<ClientRequestObject, ClientResponseObject>> getEndpointRoutes(){
        return endpointRoutes;
    }

    public void setNewEndpoint(String route, Function<ClientRequestObject, ClientResponseObject> runnableFunction) {
        endpointRoutes.put(route, runnableFunction);
    }

    public void removeEndpoint(String route) {
        endpointRoutes.remove(route);
    }


}
