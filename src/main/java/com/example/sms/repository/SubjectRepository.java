package com.example.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sms.entity.Subject;

public interface SubjectRepository  extends JpaRepository<Subject, Integer>{

}
