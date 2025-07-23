package server.iohandlers.response;

import server.model.response.ClientResponseObject;
import server.model.response.ResponseBody;
import server.model.response.ResponseLine;

final class ResponseBodyParser {

    static StringBuilder serialize(StringBuilder responseString, ClientResponseObject clientResponseObject){

        ResponseBody body = clientResponseObject.responseBody();

        return responseString.append(body.responseBody());

    }

}
