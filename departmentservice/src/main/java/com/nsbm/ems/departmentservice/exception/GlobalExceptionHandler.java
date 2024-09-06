package com.nsbm.ems.departmentservice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * Global exception handler to catch and handle exceptions across the entire application.
 * This class uses @ControllerAdvice to handle exceptions globally.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles all exceptions that are not explicitly caught by other handlers.
     *
     * @param ex      the exception that was thrown
     * @param request the web request during which the exception occurred
     * @return a ResponseEntity with a bad request status and the exception message in the body
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}