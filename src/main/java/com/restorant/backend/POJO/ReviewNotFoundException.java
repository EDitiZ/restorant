package com.restorant.backend.POJO;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ReviewNotFoundException extends Exception{

    public ReviewNotFoundException(Integer id) {
        super("Review with id " + id + " not found!");
    }
}
