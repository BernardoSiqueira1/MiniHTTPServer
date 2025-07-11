package Components.ServerParsers;

import Components.ServerObjects.ClientRequestObject;
import Components.ServerObjects.Request.RequestBody;
import Components.ServerObjects.Request.RequestHeaders;
import Components.ServerObjects.Request.RequestLine;

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
