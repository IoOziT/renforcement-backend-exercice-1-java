package com.renforcementBackend.exercice1.student.controllers;

import com.renforcementBackend.exercice1.student.dtos.IndividualStudentDto;
import com.renforcementBackend.exercice1.student.entities.School;
import com.renforcementBackend.exercice1.student.entities.Student;
import com.renforcementBackend.exercice1.student.exceptions.StudentNotFoundException;
import com.renforcementBackend.exercice1.student.feignClients.SchoolClient;
import com.renforcementBackend.exercice1.student.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private SchoolClient schoolClient;
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/{studentId}")
    public IndividualStudentDto getStudentById(@PathVariable String studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException(studentId));
        IndividualStudentDto studentDto = new IndividualStudentDto(student);

        if (student.getSchoolId() == null) {
            return studentDto;
        }

        School school = schoolClient.getSchoolById(student.getSchoolId());

        studentDto.setSchool(school);

        return studentDto;
    }

    @PatchMapping("/{studentId}")
    public Student updateStudent(@PathVariable String studentId, @RequestBody Student student) {
        Student updatedStudent = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException(studentId));

        if (student.getName() != null) {
            updatedStudent.setName(student.getName());
        }

        if (student.getAge() != null) {
            updatedStudent.setAge(student.getAge());
        }

        if (student.getGender() != null) {
            updatedStudent.setGender(student.getGender());
        }

        if (student.getSchoolId() != null) {
            updatedStudent.setSchoolId(student.getSchoolId());
        }

        studentRepository.save(updatedStudent);

        return updatedStudent;
    }

    @DeleteMapping("/{studentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable String studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw new StudentNotFoundException(studentId);
        }

        studentRepository.deleteById(studentId);
    }
}
