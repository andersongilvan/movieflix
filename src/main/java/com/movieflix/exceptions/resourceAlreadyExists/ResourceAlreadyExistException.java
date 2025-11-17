package com.movieflix.exceptions.resourceAlreadyExists;


public class ResourceAlreadyExistException extends RuntimeException {

    private String message;

    public ResourceAlreadyExistException(String message) {
        super(message);
    }

}
