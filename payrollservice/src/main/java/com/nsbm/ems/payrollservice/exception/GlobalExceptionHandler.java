package com.nsbm.ems.payrollservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * GlobalExceptionHandler is a class responsible for handling exceptions globally within the application.
 * It intercepts exceptions thrown by the application and provides custom responses.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles IllegalArgumentException thrown by the application.
     *
     * @param ex the IllegalArgumentException that was thrown
     * @return a ResponseEntity containing the error message and HTTP status code
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);  // Respond with 400 Bad Request
    }
}

