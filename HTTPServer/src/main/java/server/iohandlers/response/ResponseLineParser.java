package server.iohandlers.response;

import server.model.response.ClientResponseObject;
import server.model.response.ResponseLine;

final class ResponseLineParser {

    static StringBuilder serialize(StringBuilder responseString, ClientResponseObject clientResponseObject){

        ResponseLine line = clientResponseObject.responseLine();

        return responseString.append(line.httpVersion())
                .append(" ")
                .append(line.statusCode())
                .append(" ")
                .append(line.responseMessage())
                .append("\r\n");

    }

}
