package com.example.sms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.example.sms.entity.Subject;
import com.example.sms.service.SubjectService;
import com.example.sms.utility.ResponseStructure;

@RestController
public class SubjectController {
	
	private SubjectService subjectService;
	
	public SubjectController(SubjectService subjectService) {
		super();
		this.subjectService = subjectService;
	}


	@PostMapping("/subjects/add-subject")
	public ResponseEntity<ResponseStructure<Subject>> addSubject(@RequestBody Subject subject) {
		return subjectService.addSubject(subject);
	}
	
	@GetMapping("/subjects/display-all-subject")
	public ResponseEntity<ResponseStructure<List<Subject>>> findAllSubject() {
		return  subjectService.findAllSubject();
		
	}
	
	
}
