package com.restorant.backend.POJO;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RestaurantNotFoundException extends Exception{

    public RestaurantNotFoundException(Integer id) {
        super("Restaurant with id " + id + " was not found!");
    }
}
