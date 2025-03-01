package com.renforcementBackend.exercice1.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class StudentMicroserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(StudentMicroserviceApplication.class, args);
	}
}
