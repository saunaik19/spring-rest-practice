package com.saurabh.example.springrestpractice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.function.Supplier;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException  {
    public UserNotFoundException(String message) {
        super(message);
    }
}
