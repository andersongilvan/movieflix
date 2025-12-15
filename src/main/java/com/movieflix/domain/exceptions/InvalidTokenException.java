package com.movieflix.domain.exceptions;

public class InvalidTokenException extends RuntimeException{
    public InvalidTokenException() {
        super("Invalid Token");
    }
}
