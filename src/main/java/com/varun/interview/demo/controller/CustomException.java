package com.varun.interview.demo.controller;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {
    private HttpStatus errorCode;

    public CustomException(HttpStatus code, String errorMessage) {
        super(errorMessage);
        this.errorCode = code;
    }
}
