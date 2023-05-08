package com.grupo2.biblioteca_api.common.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
