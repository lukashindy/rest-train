package ru.mipinapi.resttrain.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestErrorResponse {

    private int status;
    private String message;
    private Long timestamp;

    public RequestErrorResponse(int status, String message, Long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

}
