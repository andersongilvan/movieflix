package com.movieflix.domain.exceptions;

public class ResourceAlreadyExistsException extends RuntimeException{
    public ResourceAlreadyExistsException() {
        super("Resource already exists");
    }
}
