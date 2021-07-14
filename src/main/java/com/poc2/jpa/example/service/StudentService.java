package com.poc2.jpa.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc2.jpa.example.entity.Student;
import com.poc2.jpa.example.repository.ProjectRepository;
import com.poc2.jpa.example.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired 
	StudentRepository sturepo;
	
	@Autowired
	ProjectRepository prepo;
	
	public Student saveuser (Student stumod) {
		
		return sturepo.save(stumod);
	}
	
	public List<Student> findallstud(){
		
		return sturepo.findAll();
		
	} 
	
	public Student finduserbyid(int id) {
		
		return sturepo.findById(id).orElse(null);
	}

	
}
