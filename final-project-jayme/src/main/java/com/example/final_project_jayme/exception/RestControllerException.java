package com.example.final_project_jayme.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerException {
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(CustomException.class)
    public String getMessage(CustomException questionException) {
        return questionException.getMessage();
    }
}
