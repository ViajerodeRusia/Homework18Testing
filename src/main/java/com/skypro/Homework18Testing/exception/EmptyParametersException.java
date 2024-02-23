package com.skypro.Homework18Testing.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmptyParametersException extends IllegalArgumentException {
    public EmptyParametersException(String message) {
        super(message);
    }
}
