package com.workintech.ecommerce.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ApiErrorResponse> handleException(ApiException apiException){
        ApiErrorResponse apiErrorResponse=new ApiErrorResponse(apiException.getMessage(),apiException.getHttpStatus(), Instant.now());
        return new ResponseEntity<>(apiErrorResponse,apiException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ApiErrorResponse> handleException(Exception exception){
        ApiErrorResponse apiErrorResponse=new ApiErrorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST, Instant.now());
        return new ResponseEntity<>(apiErrorResponse,HttpStatus.BAD_REQUEST);
    }
}
