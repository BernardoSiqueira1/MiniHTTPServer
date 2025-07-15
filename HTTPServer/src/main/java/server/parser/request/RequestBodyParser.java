package server.parser.request;

import server.model.request.RequestBody;

public final class RequestBodyParser {

    public static RequestBody parse(String fullRequest){
        try{
            String body = fullRequest.split("\r\n\r\n")[1]; // Separates the header from body (has double \r\n)
            System.out.println(body);
            return new RequestBody(body);
        }
        catch (ArrayIndexOutOfBoundsException exception){
            return new RequestBody(null);
        }
    }

}
