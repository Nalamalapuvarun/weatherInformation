package com.varun.interview.demo.controller;

import com.varun.interview.demo.json.WeatherResponseJson;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public class ErrorExceptionHandler {

    @ExceptionHandler(value = {CustomException.class})
    @ResponseStatus(BAD_REQUEST)
    protected WeatherResponseJson handleCustomException(CustomException exception) {
        return WeatherResponseJson.builder().errorMessage(exception.getMessage()).build();
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    protected WeatherResponseJson handleException(Exception exception) {
        return WeatherResponseJson.builder().errorMessage(exception.getMessage()).build();
    }
}
