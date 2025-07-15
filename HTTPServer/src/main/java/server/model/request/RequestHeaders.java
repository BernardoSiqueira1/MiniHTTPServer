package server.model.request;

import java.util.HashMap;

public record RequestHeaders(
        HashMap<String,String> requestHeaders
) {
}
