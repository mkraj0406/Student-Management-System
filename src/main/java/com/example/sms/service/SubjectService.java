package com.example.sms.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.sms.entity.Subject;
import com.example.sms.repository.SubjectRepository;
import com.example.sms.utility.ResponseStructure;

@Service
public class SubjectService {

	
	private SubjectRepository subjectRepository;

	public SubjectService(SubjectRepository subjectRepository) {
		super();
		this.subjectRepository = subjectRepository;
	}

	public ResponseEntity<ResponseStructure<Subject>> addSubject(Subject subject) {
		 Subject subjectAdded= subjectRepository.save(subject);
		
		ResponseStructure<Subject> responseStructure = new ResponseStructure<Subject>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("subject succesfully added!!");
		responseStructure.setData(subjectAdded);
		
		return new ResponseEntity<ResponseStructure<Subject>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<List<Subject>>> findAllSubject() {
		List<Subject> subjects= subjectRepository.findAll();
		
		ResponseStructure<List<Subject>> responseStructure = new ResponseStructure<List<Subject>>();
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("subjects list found successfully!!");
		responseStructure.setData(subjects);
		
		return new ResponseEntity<ResponseStructure<List<Subject>>>(responseStructure, HttpStatus.FOUND);
	}
	
	
}
