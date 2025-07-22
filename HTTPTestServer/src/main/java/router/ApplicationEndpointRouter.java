package router;

import configuration.EndpointRouterConfiguration;
import endpointhandler.DefaultNotFoundHandler;
import server.model.request.ClientRequestObject;
import server.model.response.ClientResponseObject;
import server.service.DispatcherService;

import java.util.function.Function;

public final class ApplicationEndpointRouter implements DispatcherService {

    private EndpointRouterConfiguration endpointRouterConfiguration;

    public ApplicationEndpointRouter(EndpointRouterConfiguration endpointRouterConfiguration){
        this.endpointRouterConfiguration = endpointRouterConfiguration;
    }

    @Override
    public ClientResponseObject execute(ClientRequestObject clientRequestObject) {
        
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

        // Isso não cobre possíveis erros de processamento dentro da função ou outras exceções que podem acontecer
        // mas é um teste simples, vou deixar assim
    }
}
