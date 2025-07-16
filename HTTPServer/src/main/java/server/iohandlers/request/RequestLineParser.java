package server.iohandlers.request;

import server.model.request.RequestLine;

import java.util.HashMap;

public final class RequestLineParser {

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
        String[] arrayOfQueryParams;

        try {
            arrayOfQueryParams = fullRequestPath.split("\\?")[1].split("&");
        }

        catch(ArrayIndexOutOfBoundsException exception) {
            return null;
        }

        for (String queryParam : arrayOfQueryParams) {

            String[] keyValuePair = queryParam.split("=");

            try {
                queryParams.put(keyValuePair[0], keyValuePair[1]);
            }

            catch (ArrayIndexOutOfBoundsException exception) {
                continue;
            }
            //TODO - Encontrar um jeito melhor de lidar com valores nulos.
        }

        System.out.println(queryParams);
        return queryParams;
    }

    private static String extractHttpVersion(String[] fullRequestLine){
        return fullRequestLine[2];
    }


}
