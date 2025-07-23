package server.iohandlers.response;

import server.model.response.ClientResponseObject;
import server.model.response.ResponseHeaders;
import server.model.response.ResponseLine;

import java.util.Map;

final class ResponseHeaderParser {

    static StringBuilder serialize(StringBuilder responseString, ClientResponseObject clientResponseObject){

        ResponseHeaders headers = clientResponseObject.responseHeaders();

        if (headers.headers() != null){
            for (Map.Entry<String, String> entry : headers.headers().entrySet()) {
                responseString.append(entry.getKey())
                        .append(": ")
                        .append(entry.getValue())
                        .append("\r\n");
            }
            responseString.append("\r\n");
        }

        return responseString;
    }

}
