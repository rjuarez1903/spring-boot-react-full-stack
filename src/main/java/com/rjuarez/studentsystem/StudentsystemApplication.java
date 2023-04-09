package com.rjuarez.studentsystem;

import com.rjuarez.studentsystem.models.Student;
import com.rjuarez.studentsystem.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsystemApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(StudentRepository studentRepository) {

		return (args) -> {
			Student student1 = new Student("Rodrigo Juarez", "Peña 224");
			Student student2 = new Student("Marina Calandra", "Peña 224");

			studentRepository.save(student1);
			studentRepository.save(student2);
		};
	}

}
