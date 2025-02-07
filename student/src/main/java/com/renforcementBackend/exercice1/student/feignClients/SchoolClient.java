package com.renforcementBackend.exercice1.student.feignClients;

import com.renforcementBackend.exercice1.student.entities.School;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "school-microservice")
public interface SchoolClient {
    @GetMapping("/schools/{schoolId}")
    School getSchoolById(@PathVariable Integer schoolId);
}
