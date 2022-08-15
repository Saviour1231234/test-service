package com.example.usertestproject.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse resourceNotFound(HttpServletRequest req, ResourceNotFoundException ex) {
        return getErrorResponse(req, HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorResponse resourceNotValid(HttpServletRequest req, Exception ex) {
        String message = ((MethodArgumentNotValidException) ex).getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(","));
        return getErrorResponse(req, HttpStatus.UNPROCESSABLE_ENTITY, message);
    }

    private ErrorResponse getErrorResponse(HttpServletRequest req, HttpStatus status, String message) {
        return new ErrorResponse(LocalDateTime.now(), status.value(), message, req.getRequestURI());
    }
}
