package com.renforcementBackend.exercice1.student.entities;

import com.renforcementBackend.exercice1.student.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.convert.ValueConverter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @MongoId
    private String id;
    private String name;
    private Integer age;
    private Gender gender;
    private Integer schoolId;
}
