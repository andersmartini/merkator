package merkator.micronaut.domain;

import java.util.Map;

public class Response {
    public String fromService;
    public String recieverName;
    public String body;
    public Map<String, String> headers;
    public int statusCode;
    int sentMs;
}
