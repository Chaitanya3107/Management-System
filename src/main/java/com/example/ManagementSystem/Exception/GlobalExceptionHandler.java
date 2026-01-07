package com.example.ManagementSystem.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        // This will send the "Insufficient stock" or "Part not found"
        // message directly to the frontend with a 400 Bad Request status.
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}