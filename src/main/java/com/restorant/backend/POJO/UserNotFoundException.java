package com.restorant.backend.POJO;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{
//    public UserNotFoundException(String message){
//        super(message);
//    }

    public UserNotFoundException(Integer id){
        super("Could not find User with id " + id);
    }
}
