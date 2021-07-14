package com.poc2.jpa.example.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student {

	
	private int id;
	private String firstname;
	private String lastname;
	private String mobile;
	private String email;
	
	private List<Project> project ;

	public Student() {} 
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	@ManyToMany(fetch = FetchType.LAZY,targetEntity=Project.class, cascade= CascadeType.ALL)
	@JoinTable(name="join_student_project",
			joinColumns = {
					@JoinColumn(name = "id"/* ,referencedColumnName="id" */)}, 
			inverseJoinColumns = { @JoinColumn(name = "projid"/* ,referencedColumnName="projid" */)})
	public List<Project> getProject() {
		return project;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", mobile=" + mobile
				+ ", email=" + email + ", project=" + project + "]";
	}

	public Student(int id, String firstname, String lastname, String mobile, String email,
			List<com.poc2.jpa.example.entity.Project> project) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobile = mobile;
		this.email = email;
		this.project = project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}
	

}
