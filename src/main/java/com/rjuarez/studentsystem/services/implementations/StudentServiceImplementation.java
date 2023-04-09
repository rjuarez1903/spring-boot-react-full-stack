package com.rjuarez.studentsystem.services.implementations;

import com.rjuarez.studentsystem.models.Student;
import com.rjuarez.studentsystem.repositories.StudentRepository;
import com.rjuarez.studentsystem.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
}
