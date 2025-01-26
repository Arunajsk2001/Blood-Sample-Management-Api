package com.example.bsm.exception;

public class BloodBankNotFoundById extends RuntimeException{
    private final String message;

    public BloodBankNotFoundById(String message) {

        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
