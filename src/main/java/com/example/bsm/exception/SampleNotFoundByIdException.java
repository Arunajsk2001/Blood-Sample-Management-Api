package com.example.bsm.exception;

public class SampleNotFoundByIdException extends RuntimeException {

    private String message;

    public SampleNotFoundByIdException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
