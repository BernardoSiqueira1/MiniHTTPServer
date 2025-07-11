package Components.ServerChainConfiguration;

import Components.ServerHandlers.RequestHandler;

import java.util.ArrayList;
import java.util.List;

public abstract class ChainConfiguration {

    /**
     * Non implemented extendable class, can be used to implement your own logic for the HTTP request processing.
     */

    private final ArrayList<RequestHandler> requestHandlerList;

    public ChainConfiguration(RequestHandler... requestHandlers){
        this.requestHandlerList = new ArrayList<>(List.of(requestHandlers));
    }

    public List<RequestHandler> getRequestHandlerList(){
        return requestHandlerList;
    };

}
