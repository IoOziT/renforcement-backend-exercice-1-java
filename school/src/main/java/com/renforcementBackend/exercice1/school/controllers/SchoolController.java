package com.renforcementBackend.exercice1.school.controllers;

import com.renforcementBackend.exercice1.school.entities.School;
import com.renforcementBackend.exercice1.school.exceptions.SchoolNotFoundException;
import com.renforcementBackend.exercice1.school.repositories.SchoolRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schools")
public class SchoolController {
    private final SchoolRepository schoolRepository;

    SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @GetMapping
    public List<School> getAllStudents() {
        return schoolRepository.findAll();
    }

    @PostMapping
    public School addStudent(@RequestBody School school) {
        return schoolRepository.save(school);
    }

    @GetMapping("/{schoolId}")
    public School getStudentById(@PathVariable Long schoolId) {
        return schoolRepository.findById(schoolId).orElseThrow(() -> new SchoolNotFoundException(schoolId));
    }

    @PatchMapping("/{schoolId}")
    public School updateStudent(@PathVariable Long schoolId, @RequestBody School school) {
        School updatedSchool = schoolRepository.findById(schoolId).orElseThrow(() -> new SchoolNotFoundException(schoolId));

        if (school.getName() != null) {
            updatedSchool.setName(school.getName());
        }

        if (school.getAddress() != null) {
            updatedSchool.setAddress(school.getAddress());
        }

        if (school.getDirectorName() != null) {
            updatedSchool.setDirectorName(school.getDirectorName());
        }

        schoolRepository.save(updatedSchool);

        return updatedSchool;
    }

    @DeleteMapping("/{schoolId}")
    public void deleteStudent(@PathVariable Long schoolId) {
        if (!schoolRepository.existsById(schoolId)) {
            throw new SchoolNotFoundException(schoolId);
        };

        schoolRepository.deleteById(schoolId);
    }
}
