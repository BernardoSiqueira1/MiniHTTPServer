package server.iohandlers.response;

import server.model.response.ClientResponseObject;
import server.model.response.ResponseBody;
import server.model.response.ResponseHeaders;
import server.model.response.ResponseLine;

import java.util.Map;

public final class ResponseSerializer{

    public static String format(ClientResponseObject clientResponseObject) {
        ResponseLine line = clientResponseObject.responseLine();
        ResponseHeaders headers = clientResponseObject.responseHeaders();
        ResponseBody body = clientResponseObject.responseBody();

        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append(line.httpVersion())
                .append(" ")
                .append(line.statusCode())
                .append(" ")
                .append(line.responseMessage())
                .append("\r\n");

        for (Map.Entry<String, String> entry : headers.headers().entrySet()) {
            responseBuilder.append(entry.getKey())
                    .append(": ")
                    .append(entry.getValue())
                    .append("\r\n");
        }

        responseBuilder.append("\r\n");

        responseBuilder.append(body.responseBody());

        return responseBuilder.toString();
    }


}
