package com.a00n.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.a00n.entities.Student;
import com.a00n.repositories.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/all")
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @PostMapping("/create")
    public Student create(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @DeleteMapping("/student/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        try {
            System.out.println("hello");
            Student std = studentRepository.findById(id).get();
            System.out.println(std);
            studentRepository.delete(std);
            return ResponseEntity.ok("Student with ID " + id + " deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Student with ID " + id + " not found.");
        }
    }

    @GetMapping("/count")
    public long count() {
        return studentRepository.count();
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(studentRepository.findById(id).get());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Student with ID " + id + " not found.");
        }
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody Student updatedStudent) {
        try {
            Optional<Student> existingStudent = studentRepository.findById(id);
            if (existingStudent.isPresent()) {
                Student student = existingStudent.get();

                student.setFname(updatedStudent.getFname());
                student.setLname(updatedStudent.getLname());
                student.setCity(updatedStudent.getCity());
                student.setGender(updatedStudent.getGender());
                // student.setDateNaissance(updatedStudent.getDateNaissance());

                studentRepository.save(student);

                return ResponseEntity.ok(student);
            } else {
                String message = "Student with ID " + id + " not found.";
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
            }
        } catch (Exception e) {
            String message = "Student with ID " + id + " not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }

    }

}