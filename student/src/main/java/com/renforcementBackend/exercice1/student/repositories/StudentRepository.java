package com.renforcementBackend.exercice1.student.repositories;

import com.renforcementBackend.exercice1.student.entities.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
}
