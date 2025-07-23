package server.iohandlers.request;

import server.model.request.ClientRequestObject;
import server.model.request.RequestBody;
import server.model.request.RequestHeaders;
import server.model.request.RequestLine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class RequestParser {


    public static ClientRequestObject parse(InputStream clientInputStream) throws IOException {

        int currentChar;
        StringBuilder fullRequest = new StringBuilder();
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(clientInputStream));

        while (true){
            currentChar = inputReader.read();

            if (currentChar != -1){
                fullRequest.append((char) currentChar);
            }

            else {
                break;
            }

        }

        RequestLine requestLine = RequestLineParser.parse(fullRequest.toString());
        RequestHeaders requestHeaders = RequestHeaderParser.parse(fullRequest.toString());
        RequestBody requestBody = RequestBodyParser.parse(fullRequest.toString());

        return new ClientRequestObject(requestLine, requestHeaders, requestBody);
    }

}
