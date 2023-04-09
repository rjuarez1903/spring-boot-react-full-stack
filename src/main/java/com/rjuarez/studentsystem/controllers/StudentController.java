package com.rjuarez.studentsystem.controllers;

import com.rjuarez.studentsystem.models.Student;
import com.rjuarez.studentsystem.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public ResponseEntity<Object> addStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return new ResponseEntity<>("Student added", HttpStatus.CREATED);
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
}
