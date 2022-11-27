package com.deepee.deepee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserException extends RuntimeException {

    private HttpStatus status;

    private String message;

    public UserException(){}

    public UserException(String message){
        super(message);
    }

    public UserException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
