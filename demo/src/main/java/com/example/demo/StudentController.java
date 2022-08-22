package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@GetMapping("/getstudent")
	public Student getStudent() {
		return new Student("Sampath", "Donthula");
	}
	@GetMapping("/students")
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<>();
		students.add(new Student("Sam", "Don"));
		students.add(new Student("div", "vad"));
		students.add(new Student("Sampu", "Dontu"));
		return students;
		
	}
	// PathVariable is to bind the url temp variables to method arguments/////////
	/////   @PathVariable("firstName") is same as {firstName}////////////////////
	@GetMapping("{firstName}/{lastName}")  //// url template path variables///////////////
	public Student studentPathVariable(@PathVariable("firstName") String firstName, @PathVariable("lastName")
			String lastName) {
		return new Student(firstName, lastName);
	}
	
	////rest api to handle query parameters (?)
	@GetMapping("/query")
	public Student studentQuery(@RequestParam(name = firstName) String firstName, @RequestParam(name = lastName) String lastName) {
		return new Student(firstName, lastName);
	}
	
	
	
	
}
