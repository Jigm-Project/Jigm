package com.jigmproject.subtitlegenerator.exception;

// 특정 리소스를 찾지 못했을 때 발생하는 예외
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
