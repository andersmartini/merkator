package merkator.micronaut.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Map;

@JsonDeserialize
public class Request {
    public String receiver;
    public String sender;
    public String trackId;
    public int receivedMs;
    public int sentMs;
    public String body;

    public Request(
    @JsonProperty("receiver") String receiver,
    @JsonProperty("sender") String sender,
    @JsonProperty("trackId") String trackId,
    @JsonProperty("receivedMs") int receivedMs,
    @JsonProperty("sentMs") int sentMs,
    @JsonProperty("body") String body
    ) {
        this.receiver = receiver;
        this.sender = sender;
        this.trackId = trackId;
        this.receivedMs = receivedMs;
        this.sentMs = sentMs;
        this.body = body;
    }



}
