package com.test.city.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SightNotFoundException extends RuntimeException {

    public SightNotFoundException(String message) {
        super(message);
    }

}
