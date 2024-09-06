package com.nsbm.ems.employeeservice.exception;

// Custom exception class for handling user not found scenarios
public class UserNotFoundException extends RuntimeException {

    // Constructor with error message
    public UserNotFoundException(String message) {
        super(message);
    }

    // Constructor with error message and cause
    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
