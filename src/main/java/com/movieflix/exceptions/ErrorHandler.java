package com.movieflix.exceptions;


import com.movieflix.domain.streaming.DTO.MethodArgumentNotValidExceptionDto;
import com.movieflix.exceptions.resourceAlreadyExists.ResourceAlreadyExistException;
import com.movieflix.exceptions.resourceAlreadyExists.ResourceNotFoundExceptionDto;
import com.movieflix.exceptions.resourceNotFound.ResourceAlreadyExistExceptionDto;
import com.movieflix.exceptions.resourceNotFound.ResourceNorFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(ResourceNorFoundException.class)
    public ResponseEntity<ResourceNotFoundExceptionDto> resourceNotFoundException
            (ResourceNorFoundException e) {
        var errors = new ResourceNotFoundExceptionDto(e.getMessage());

        return ResponseEntity.status(404).body(errors);
    }

    @ExceptionHandler(ResourceAlreadyExistException.class)
    public ResponseEntity<ResourceAlreadyExistExceptionDto> resourceAlreadyExistException
            (ResourceAlreadyExistException e) {
        var errors = new ResourceAlreadyExistExceptionDto(e.getMessage());

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<MethodArgumentNotValidExceptionDto>> methodArgumentNotValidException
            (MethodArgumentNotValidException e) {
            List<MethodArgumentNotValidExceptionDto> errorsList = new ArrayList<>();

            var errors = e.getFieldErrors();

            errors.forEach(err -> errorsList.add( new MethodArgumentNotValidExceptionDto
                    (err.getField(), err.getDefaultMessage())));

            return ResponseEntity.badRequest().body(errorsList);
    }

}
