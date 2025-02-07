package com.renforcementBackend.exercice1.student.dtos;

import com.renforcementBackend.exercice1.student.entities.School;
import com.renforcementBackend.exercice1.student.entities.Student;
import com.renforcementBackend.exercice1.student.enums.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
public class IndividualStudentDto {
    private final String id;
    private final String name;
    private final Integer age;
    private final Gender gender;
    @Setter
    private School school;

    public IndividualStudentDto (Student student, School school) {
        this.id = student.getId();
        this.name = student.getName();
        this.age = student.getAge();
        this.gender = student.getGender();
        this.school = school;
    }

    public IndividualStudentDto (Student student) {
        this(student, null);
    }

}
