package com.thoughtworks.capacity.gtb.mvc.exception;

public class LoginInformationErrorException extends RuntimeException {
    public LoginInformationErrorException(String message) {
        super(message);
    }
}