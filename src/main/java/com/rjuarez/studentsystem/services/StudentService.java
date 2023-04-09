package com.rjuarez.studentsystem.services;

import com.rjuarez.studentsystem.models.Student;

import java.util.List;

public interface StudentService {
    void saveStudent(Student student);
    List<Student> getStudents();
}
