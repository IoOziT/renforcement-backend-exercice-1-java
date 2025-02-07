package com.renforcementBackend.exercice1.school.repositories;

import com.renforcementBackend.exercice1.school.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
}
