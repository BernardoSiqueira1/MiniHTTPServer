package server.iohandlers.response;

import server.model.response.ClientResponseObject;
import server.model.response.ResponseBody;
import server.model.response.ResponseHeaders;
import server.model.response.ResponseLine;

import java.util.Map;

public final class ResponseSerializer{

    public static String serialize(ClientResponseObject clientResponseObject) {

        StringBuilder responseBuilder = new StringBuilder();

        ResponseLineParser.serialize(responseBuilder, clientResponseObject);
        ResponseHeaderParser.serialize(responseBuilder, clientResponseObject);
        ResponseBodyParser.serialize(responseBuilder, clientResponseObject);

        return responseBuilder.toString();

    }

}
