package com.example.springdemo.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@AllArgsConstructor
public enum CodeException {
    USER_NOT_FOUND(404, "User not found", HttpStatus.NOT_FOUND);

    private int code;
    private String message;
    private HttpStatusCode httpStatusCode;

    private static final Map<CodeException, AppException> EXCEPTIONS = new ConcurrentHashMap<>();

    public AppException throwException() {
        return EXCEPTIONS.computeIfAbsent(this, AppException::new);
    }
}