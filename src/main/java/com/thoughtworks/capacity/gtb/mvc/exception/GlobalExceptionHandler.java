package com.thoughtworks.capacity.gtb.mvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.LinkedList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({UserNameExistException.class, LoginInformationErrorException.class})
    public ResponseEntity<ErrorMessage> handle(Exception ex) {
        ErrorMessage errorMessage = new ErrorMessage("400 - Bad Request", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorMessage>> handle(MethodArgumentNotValidException ex) {
        List<ErrorMessage> errorMessages = new LinkedList<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> errorMessages.add(new ErrorMessage("400 - Bad Request", fieldError.getDefaultMessage())));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<ErrorMessage>> handle(ConstraintViolationException ex) {
        List<ErrorMessage> errorMessages = new LinkedList<>();
        ex.getConstraintViolations().forEach(constraintViolation -> errorMessages.add(new ErrorMessage("400 - Bad Request", constraintViolation.getMessage())));
        return ResponseEntity.badRequest().body(errorMessages);
    }
}
