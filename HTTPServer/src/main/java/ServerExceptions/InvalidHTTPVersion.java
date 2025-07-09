package ServerExceptions;

public class InvalidHTTPVersion extends RuntimeException {
    public InvalidHTTPVersion() {
        super("Invalid HTTP Version by the sent request.");
    }
}
