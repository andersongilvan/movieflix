package com.movieflix.exceptions.resourceNotFound;

public class ResourceNorFoundException extends RuntimeException {

    private String message;

    public ResourceNorFoundException(String message) {
        super(message);
    }

}
