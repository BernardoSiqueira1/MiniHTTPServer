package server.model.response;

public record ResponseLine(
        int statusCode,
        String responseMessage,
        String httpVersion
) {


}
