package server.model.response;

import java.util.HashMap;

public record ClientResponseObject(
        ResponseLine responseLine,
        ResponseHeaders responseHeaders,
        ResponseBody responseBody
) {}
