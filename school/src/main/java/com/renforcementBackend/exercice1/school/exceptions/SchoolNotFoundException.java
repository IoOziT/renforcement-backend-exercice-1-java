package com.renforcementBackend.exercice1.school.exceptions;

public class SchoolNotFoundException extends  RuntimeException {
    public SchoolNotFoundException(Long id) {
        super("School with id " + id + " not found");
    }
}
