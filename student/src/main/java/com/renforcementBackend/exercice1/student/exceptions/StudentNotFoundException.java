package com.renforcementBackend.exercice1.student.exceptions;

public class StudentNotFoundException extends  RuntimeException {
    public StudentNotFoundException(String id) {
        super("Student with id " + id + " not found");
    }
}
