package server.exceptions;

public class ThirdPartyServiceNotSetup extends RuntimeException {
    public ThirdPartyServiceNotSetup() {
        super("The service call could not be complete because there are no third party services configured for this server.");
    }
}
