package com.zero.admin.panel.error;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}
