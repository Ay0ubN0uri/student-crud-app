package com.a00n.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.a00n.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}