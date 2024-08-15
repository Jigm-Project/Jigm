package com.jigmproject.subtitlegenerator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExceptionTest extends RuntimeException {

    public ResourceNotFoundExceptionTest(String message) {
        super(message);
    }
}