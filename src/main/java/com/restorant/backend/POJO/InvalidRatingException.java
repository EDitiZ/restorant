package com.restorant.backend.POJO;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidRatingException extends Exception{

    public InvalidRatingException(String message) {
        super(message);
    }
}
