package com.renforcementBackend.exercice1.student.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class School {
    private Long id;
    private String name;
    private String address;
    private String directorName;
}
