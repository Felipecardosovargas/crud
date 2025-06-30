package com.teach.crud.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExptionHandle {

    @ExceptionHandler
    public ResponseEntity<ExceptionDTOReqs> noFoundExeption(ClassNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDTOReqs(HttpStatus.NOT_FOUND, e .getMessage()));
    }
}
