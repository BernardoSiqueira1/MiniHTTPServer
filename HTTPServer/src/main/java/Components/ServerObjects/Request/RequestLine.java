package Components.ServerObjects.Request;

import java.util.HashMap;

public record RequestLine(

        String httpVersion,
        String fullPath,
        String clearPath,
        String method,
        HashMap<String, String> queryParams,
        String[] pathParams
) {
}
