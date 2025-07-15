package server.parser.request;

import server.model.request.RequestHeaders;

import java.util.HashMap;

public final class RequestHeaderParser {

    public static RequestHeaders parse(String fullRequest){
        HashMap<String, String> requestHeadersMap = new HashMap<>();

        try{
            String[] requestHeaders = getRequestHeaders(fullRequest);

            for (String header : requestHeaders){

                try{
                    String[] headerKeyValuePair = header.split(":");
                    requestHeadersMap.put(headerKeyValuePair[0], headerKeyValuePair[1]);
                }

                catch (ArrayIndexOutOfBoundsException exception){
                    continue;
                }

                //TODO - Encontrar um jeito melhor de lidar com valores nulos.
            }
        }

        catch (ArrayIndexOutOfBoundsException exception){
            return null;
        }

        return new RequestHeaders(requestHeadersMap);
    }

    private static String[] getRequestHeaders(String fullRequest){
        return fullRequest
                .split("\r\n\r\n")[0] // Separates the header from body (has double \r\n)
                .split("\r\n",2)[1] // Now separates the request line from all headers
                .split("\r\n"); // Gets all the request headers separate
    }

}
