package com.example.sms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.sms.entity.Student;
import com.example.sms.entity.Subject;
import com.example.sms.repository.StudentRepository;
import com.example.sms.repository.SubjectRepository;
import com.example.sms.utility.ResponseStructure;

@Service
public class StudentService {
	
	private StudentRepository studentRepository;
	
	private SubjectRepository subjectRepository;
	
	
	public StudentService(StudentRepository studentRepository, SubjectRepository subjectRepository) {
		super();
		this.studentRepository = studentRepository;
		this.subjectRepository = subjectRepository;
	}



	public ResponseEntity<ResponseStructure<Student>> createStudent(Student student) {
		Student studentObject = studentRepository.save(student);
		
		ResponseStructure<Student> responseStructure = new ResponseStructure<Student>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Student Object Created succesfully!!");
		responseStructure.setData(student);
		
		return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.CREATED);
		
	}



	public ResponseEntity<ResponseStructure<List<Student>>> findAllStudent() {
		List<Student> students= studentRepository.findAll();
		
		ResponseStructure<List<Student>> responseStructure = new ResponseStructure<List<Student>>();
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("found all student data!!");
		responseStructure.setData(students);
		
		return new ResponseEntity<ResponseStructure<List<Student>>>(responseStructure , HttpStatus.FOUND);
	}



	public ResponseEntity<ResponseStructure<Student>> addSubjectToStudent(int student_id, int subject_Id) {
		Optional<Student> optionalStudent= studentRepository.findById(student_id);
		
		Optional<Subject> optionalSubject= subjectRepository.findById(subject_Id);
		
		if(optionalStudent.isPresent() && optionalSubject.isPresent()) {
			Student student = optionalStudent.get();
			Subject subject = optionalSubject.get();
			
			student.getSubjects().add(subject);
			
			Student studentwithsubject= studentRepository.save(student);
			
			ResponseStructure<Student> responseStructure = new ResponseStructure<Student>();
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Subject successfully enrolled for student");
			responseStructure.setData(studentwithsubject);
			
			return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.CREATED);
		}else {
			return null;
		}
	}
	
	
	
	
}
