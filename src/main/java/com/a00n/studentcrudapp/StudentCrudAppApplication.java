package com.a00n.studentcrudapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.a00n.controllers" })
@EntityScan(basePackages = { "com.a00n.entities" })
@EnableJpaRepositories(basePackages = { "com.a00n.repositories" })
public class StudentCrudAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentCrudAppApplication.class, args);
	}

}
