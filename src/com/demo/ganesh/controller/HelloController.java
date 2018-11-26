package com.demo.ganesh.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ganesh.model.CustomError;
import com.demo.ganesh.model.Student;

@RestController
@RequestMapping(value="/api")
//@RequestMapping("/first")
public class HelloController {

	@ExceptionHandler
	public ResponseEntity<CustomError> handleExcep(RuntimeException re)
	{
		CustomError ce = new CustomError(HttpStatus.BAD_REQUEST.toString(), re.getMessage());
		return new ResponseEntity<CustomError>(ce,HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/")
	public String defaultPage() {
		return "Hello world!!";
	}
	
	@PostMapping("/login")
	public String login() {
		return "you are logged in.";
	}
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello world!!";
	}
	
	@GetMapping("/students")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public List<Student> getStudents() {
		List<Student> result = fetchStudents();
		
		return result;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		try {
			List<Student> result = fetchStudents();
			
			return result.get(studentId);
		}
		catch(Exception e)
		{
			throw new RuntimeException("Some Error Occurred");
		}
	}

	private List<Student> fetchStudents() {
		List<Student> result = new ArrayList<Student>();
		Student s = new Student();
		s.setName("Ganesh");
		s.setCourse("MCA");
		s.setAddress("New Delhi");
		result.add(s);
		
		s = new Student();
		s.setName("Ramesh");
		s.setCourse("Accounts");
		s.setAddress("Delhi");
		result.add(s);
		
		s = new Student();
		s.setName("Ajay");
		s.setCourse("Science");
		s.setAddress("Delhi");
		result.add(s);
		return result;
	}
}
