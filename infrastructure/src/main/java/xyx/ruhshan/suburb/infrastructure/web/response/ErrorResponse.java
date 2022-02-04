package xyx.ruhshan.suburb.infrastructure.web.response;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
public class ErrorResponse implements Serializable {
    private String message;
    private Instant timeStamp;

    public ErrorResponse(String message){
        this.message = message;
        this.timeStamp = Instant.now();
    }
}
