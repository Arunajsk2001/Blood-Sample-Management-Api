package com.example.bsm.exception;

import lombok.NoArgsConstructor;


public class HospitalNotFoundByIdException extends RuntimeException{

    private final String message;

    public HospitalNotFoundByIdException(String message) {

        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
