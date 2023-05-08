package com.grupo2.biblioteca_api.common.exceptions;

public class ForbiddenException extends RuntimeException{

    public ForbiddenException(String msg) {
        super(msg);
    }
}