package ru.folkland.services;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

//@RestControllerAdvice
public class BarAdvice {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, HttpServletResponse response) {
        return e.getMessage();
    }
}
