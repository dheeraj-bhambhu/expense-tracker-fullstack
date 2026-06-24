package com.dheeraj.expensetracker.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.dheeraj.expensetracker.dto.ErrorResponse;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleValidationException(
            MethodArgumentNotValidException ex){

        Map<String,String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(
                    error.getField(),
                    error.getDefaultMessage()
            );
        });

        return errors;
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ErrorResponse handleResourceNotFoundException(
            ResourceNotFoundException ex){

        return new ErrorResponse(
                LocalDateTime.now(),
                404,
                ex.getMessage()
        );
    }
    @ExceptionHandler(DuplicateResourceException.class)
    public Map<String,String> handleDuplicateResourceException(
            DuplicateResourceException ex){

        Map<String,String> error = new HashMap<>();

        error.put("message", ex.getMessage());

        return error;
    }
    @ExceptionHandler(Exception.class)
    public Map<String,String> handleException(Exception ex){

        Map<String,String> error = new HashMap<>();

        error.put("message", ex.getMessage());

        return error;
    }

}