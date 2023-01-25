package com.restorant.backend.POJO;

public class EntityNotFoundException extends Throwable{

    public String desc;

    public EntityNotFoundException(String desc) {
        this.desc = desc;
    }

    public void print(){
        System.out.println(this.desc);
    }
}
