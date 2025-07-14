package server.parser;

import server.model.request.ClientRequestObject;
import server.model.request.RequestBody;
import server.model.request.RequestHeaders;
import server.model.request.RequestLine;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class RequestParser {


    public ClientRequestObject parse(InputStream clientInputStream) throws IOException {

        StringBuilder fullRequest = new StringBuilder();
        Scanner inputScanner = new Scanner(clientInputStream).useDelimiter("\\A");

        while (inputScanner.hasNext()){
            try {
                fullRequest.append(inputScanner.next());
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                break;
            }
        }

        System.out.println(fullRequest);
        RequestLine requestLine = RequestLineParser.parse(fullRequest.toString());
        RequestHeaders requestHeaders = null;
        RequestBody requestBody = null;

        return null;
    }

}
