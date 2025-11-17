package com.movieflix.exceptions;

public class ResourceNorFoundException extends RuntimeException {

    private String message;

    public ResourceNorFoundException(String message) {
        super(message);
    }

}
