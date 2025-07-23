package server.exceptions;

public class FailedToSendResponseException extends RuntimeException {
    public FailedToSendResponseException() {
        super("Failed to return a message to client.");
    }
}
