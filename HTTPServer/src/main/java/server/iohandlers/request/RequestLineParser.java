package server.iohandlers.request;

import server.model.request.RequestLine;

import java.util.HashMap;

public final class RequestLineParser {

    public static RequestLine parse(String fullRequest){

        String requestMethod, fullPath, httpVersion, clearPath, joinedQueryParams;
        HashMap<String,String> queryParams;

        String[] fullRequestLine = fullRequest.split("\n")[0].split(" ");

        requestMethod = extractRequestMethod(fullRequestLine);
        fullPath = extractFullRequestPath(fullRequestLine);
        clearPath = extractClearPath(fullPath);
        httpVersion = extractHttpVersion(fullRequestLine);

        queryParams = extractQueryParams(fullPath);

        System.out.println(requestMethod);
        System.out.println(fullPath);
        System.out.println(clearPath);
        System.out.println(httpVersion);
        System.out.println(queryParams);

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
        String[] arrayOfQueryParams;

        try {
            arrayOfQueryParams = fullRequestPath.strip().split("\\?")[1].split("&"); // ex. query1=2 '&' query2=3
        }

        catch(ArrayIndexOutOfBoundsException exception) {
            return null;
        }

        for (String queryParam : arrayOfQueryParams) {

            String[] keyValuePair = queryParam.split("=", 2);

            queryParams.put(keyValuePair[0], keyValuePair[1]);

        }

        return queryParams;
    }

    private static String extractHttpVersion(String[] fullRequestLine){
        return fullRequestLine[2];
    }


}
