package com.example.appmotel.exceptions;
public class EntityNotFound extends RuntimeException{
    public EntityNotFound(String message){
        super(message);
    }
}