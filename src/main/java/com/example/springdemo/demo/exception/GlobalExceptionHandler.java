package com.example.springdemo.demo.exception;

import com.example.springdemo.demo.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException e) {
        ApiResponse apiResponse = new ApiResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }
}