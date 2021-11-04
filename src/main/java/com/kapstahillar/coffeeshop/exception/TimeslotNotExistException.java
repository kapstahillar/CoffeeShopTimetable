package com.kapstahillar.coffeeshop.exception;

public class TimeslotNotExistException extends  Exception {
    public TimeslotNotExistException(String errorMessage) {
        super(errorMessage);
    }
}
