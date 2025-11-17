package com.movieflix.exceptions;


public class ResourceAlreadyExistException extends RuntimeException {

    private String message;

    public ResourceAlreadyExistException(String message) {
        super(message);
    }

}
