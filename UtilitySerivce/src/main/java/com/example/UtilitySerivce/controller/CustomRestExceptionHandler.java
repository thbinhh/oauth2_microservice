package com.example.UtilitySerivce.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class CustomRestExceptionHandler {
    @ExceptionHandler(value = {AccessDeniedException.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        return new ResponseEntity<Object>(
                "Acces denied Exception", new HttpHeaders(), HttpStatus.FORBIDDEN);
    }
}
