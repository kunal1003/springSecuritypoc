package com.poc2.jpa.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc2.jpa.example.entity.AuthRequest;
import com.poc2.jpa.example.entity.Project;
import com.poc2.jpa.example.entity.Student;
import com.poc2.jpa.example.model.User;
import com.poc2.jpa.example.repository.UserRepository;
import com.poc2.jpa.example.service.ProjectService;
import com.poc2.jpa.example.service.StudentService;
import com.poc2.jpa.example.util.JwtUtil;

@RestController
public class StudentController {

	@Autowired
	StudentService sserv;
	@Autowired
	ProjectService pserv;
	@Autowired
	UserRepository urepo;
	
	@Autowired
	 private BCryptPasswordEncoder passwordEncoder;
	
	
	@Autowired
	private JwtUtil jwtutil;
	
	@Autowired
	private AuthenticationManager authenticationmanager;
	@GetMapping("/")
	public String welcomepage() {
		return "welcome";
	}

	@PostMapping("/addstudent")
	public Student addstudent(@RequestBody Student stumod) {
		return sserv.saveuser(stumod);

	}

	@GetMapping("/findstudent")
	public List<Student> findAllStudent() {
		return sserv.findallstud();
	}

	@GetMapping("/findstudentbyid/{id}")
	public Student getstudbyid(@PathVariable int id) {

		return sserv.finduserbyid(id);
	}
	
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authreq) throws Exception {
		
	try {	
		authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(authreq.getUsername(),authreq.getPassword()));
		
	}
	catch(Exception ex) {
	
		throw new Exception("invalid username pass");
		
	}
	
	
 return	jwtutil.generateToken(authreq.getUsername());
		
	}

	
	
}
