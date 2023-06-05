package com.example.appmotel.exceptions;

public class EntityConflict extends RuntimeException{
    private static final Long serialVersionUID = 1L;
    public EntityConflict(String message){
        super(message);

    }
}
