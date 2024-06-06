package com.example.springdemo.demo.exception;

import com.example.springdemo.demo.dto.ApiErrorResponse;
import com.example.springdemo.demo.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleResourceNotFoundException(ResourceNotFoundException e) {
        ApiErrorResponse apiResponse = new ApiErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }
}