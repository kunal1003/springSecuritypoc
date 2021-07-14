package com.poc2.jpa.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc2.jpa.example.model.User;
import com.poc2.jpa.example.repository.UserRepository;

@RestController
@RequestMapping("/secure/rest")
public class AdminController {

	@Autowired
	UserRepository urepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder ;
	
	
	@PostMapping("/admin/add")
	public String adduserByAdmin(@RequestBody User user) {
		
		String pwd= user.getPassword();
		String encryptPwd=passwordEncoder.encode(pwd);
		user.setPassword(encryptPwd); 
		urepo.save(user);
		return "user added successfully";
	}
	
	@GetMapping("/")
	public String welcome() {
		
		return "welcome page";
	}
	
		
	
	
	
	}
