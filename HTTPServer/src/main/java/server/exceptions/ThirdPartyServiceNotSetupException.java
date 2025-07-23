package server.exceptions;

public class ThirdPartyServiceNotSetupException extends RuntimeException {
    public ThirdPartyServiceNotSetupException() {
        super("The service call could not be complete because there are no third party services configured for this server.");
    }
}
