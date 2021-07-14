package com.poc2.jpa.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc2.jpa.example.entity.Project;
import com.poc2.jpa.example.repository.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	ProjectRepository prepo;
	
	public Project saveProject(Project proj) {
		
		return prepo.save(proj);
	}

}
