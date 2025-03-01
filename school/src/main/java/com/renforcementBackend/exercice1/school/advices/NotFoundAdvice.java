package com.renforcementBackend.exercice1.school.advices;

import com.renforcementBackend.exercice1.school.exceptions.SchoolNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NotFoundAdvice {
    @ExceptionHandler(SchoolNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String schoolNotFoundHandler(SchoolNotFoundException ex) {
        return ex.getMessage();
    }
}
