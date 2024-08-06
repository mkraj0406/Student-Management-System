package com.example.sms.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sms.entity.Student;
import com.example.sms.entity.Subject;
import com.example.sms.service.StudentService;
import com.example.sms.utility.ResponseStructure;

@RestController
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	

	@PostMapping("/students/create-student")
	public ResponseEntity<ResponseStructure<Student>> createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}

	@GetMapping("/student/display-all-student")
	public ResponseEntity<ResponseStructure<List<Student>>> findAllStudent() {
		return studentService.findAllStudent();
	}
	
	@PostMapping("/students/add-subject-to-student")
	public ResponseEntity<ResponseStructure<Student>> addSubjectToStudent(@RequestParam int student_id,@RequestParam int subject_id) {
		return studentService.addSubjectToStudent(student_id,subject_id);
	}

}
