package com.renforcementBackend.exercice1.student.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {
    MALE, FEMALE, OTHER;

    @JsonValue
    public String getValue() {
        return this.name().toLowerCase();
    }

    @JsonCreator
    public static Gender fromValue(String gender) {
        return Gender.valueOf(gender.toUpperCase());
    }
}
