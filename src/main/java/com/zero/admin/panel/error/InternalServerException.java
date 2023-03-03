package com.zero.admin.panel.error;

public class InternalServerException extends RuntimeException{
    public InternalServerException(String message){
        super(message);
    }
}
