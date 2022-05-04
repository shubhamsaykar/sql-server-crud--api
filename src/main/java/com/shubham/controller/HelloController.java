package com.shubham.controller;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import com.shubham.model.Student;
import com.shubham.repository.StudentRepository;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;

@Controller
public class HelloController {

	@Inject
	public StudentRepository studentRepository;

//	@Get("/hello")
//	public String Hello() {
//		return "Hello World";
//	}

	@Get("/getStudent")
	public List<Student> getStudent() {
		return (List<Student>) studentRepository.findAll();

	}
//
	@Get("/getstudent/{id}")
	public Optional<Student> getStudentById(int id) {
		return studentRepository.findById(id);

	}
//
	@Post("/addstudents")
	public Student addStudents(@Body Student student) {
		return studentRepository.save(student);

	}
//	
//	
	@Put("/updateStudent/{id}")
	public Student updateStudent(int id, @Body Student student) {
		if (studentRepository.existsById(id)) {
			student.setId(id);
			studentRepository.update(student);
		}
		return student;
	}
//	
	@Delete("/{id}")
	public void deletestudent(int id) {
		if(studentRepository.existsById(id)) {
			studentRepository.deleteById(id);
		}
	}

}
