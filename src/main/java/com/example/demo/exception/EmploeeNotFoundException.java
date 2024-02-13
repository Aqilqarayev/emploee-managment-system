package com.example.demo.exception;

public class EmploeeNotFoundException extends RuntimeException{
    public EmploeeNotFoundException(String message) {
        super(message);
    }

}
