package org.jyj.branch.exception;

import java.time.Instant;

public class ApiError {

    private int status;
    private String message;
    private Instant timestamp;

    private ApiError(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = Instant.now();
    }

    public static ApiError of(int status, String message) {
        return new ApiError(status, message);
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}