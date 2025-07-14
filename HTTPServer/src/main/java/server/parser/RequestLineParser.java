package server.parser;

import server.model.request.RequestLine;

import java.util.HashMap;

public class RequestLineParser {

    public static RequestLine parse(String fullRequest){

        String requestMethod, fullPath, httpVersion, clearPath, joinedQueryParams;
        HashMap<String,String> queryParams = new HashMap<>();

        String[] fullRequestLine = fullRequest.split("\n")[0].split(" ");

        requestMethod = extractRequestMethod(fullRequestLine);
        fullPath = extractFullRequestPath(fullRequestLine);
        clearPath = extractClearPath(fullPath);
        httpVersion = extractHttpVersion(fullRequestLine);

        queryParams = extractQueryParams(fullPath);


        return new RequestLine(httpVersion, fullPath, clearPath, requestMethod, queryParams, null);
    }

    private static String extractRequestMethod(String[] fullRequestLine){
        return fullRequestLine[0];
    }

    private static String extractFullRequestPath(String[] fullRequestLine){
        return fullRequestLine[1];
    }

    private static String extractClearPath(String fullRequestPath){
    return fullRequestPath.split("\\?")[0];
    }

    private static HashMap<String, String> extractQueryParams(String fullRequestPath){
        HashMap<String, String> queryParams = new HashMap();
        String[] arrayOfQueryParams = fullRequestPath.split("\\?")[1].split("&");

        for(int index = 0; index < arrayOfQueryParams.length; ++index) {
            String[] keyValuePair = arrayOfQueryParams[index].split("=");

            try {
                queryParams.put(keyValuePair[0], keyValuePair[1]);
            } catch (ArrayIndexOutOfBoundsException exception) {
                System.out.println(exception.getMessage());
            }
        }

        System.out.println(queryParams);
        return queryParams;
    }

    private static String extractHttpVersion(String[] fullRequestLine){
        return fullRequestLine[2];
    }


}
