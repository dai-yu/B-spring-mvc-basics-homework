package com.thoughtworks.capacity.gtb.mvc.exception;

public class UserNameExistException extends RuntimeException {
    public UserNameExistException(String message) {
        super(message);
    }
}
