package server.configuration;

import server.service.DispatcherService;

public final class DispatcherConfiguration {

    private DispatcherService applicationService;

    public DispatcherConfiguration (DispatcherService applicationDispatcherServiceImpl){
        this.applicationService = applicationDispatcherServiceImpl;
    }

    public DispatcherService getService(){
        return this.applicationService;
    }
}
