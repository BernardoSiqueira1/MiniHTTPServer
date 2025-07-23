package server.iohandlers.request;

import server.model.request.RequestHeaders;

import java.util.Arrays;
import java.util.HashMap;

final class RequestHeaderParser {

    static RequestHeaders parse(String fullRequest){
        HashMap<String, String> requestHeadersMap = new HashMap<>();

        String[] requestHeaders = getRequestHeaders(fullRequest);

        for (String header : requestHeaders){

            try{
                String[] headerKeyValuePair = header.strip().split(":");
                requestHeadersMap.put(headerKeyValuePair[0], headerKeyValuePair[1]);
            }

            catch (ArrayIndexOutOfBoundsException exception) {
                continue; // ignore malformed headers
            }

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
