package com.poc2.jpa.example.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
public class Project {

	private int projid;
	private String projectname;
	private String duration;
	private List<Student> student;

	public Project() {}
	
	@Id
	/* @GeneratedValue(strategy = GenerationType.AUTO) */
	public int getProjid() {
		return projid;
	}

	public void setProjid(int projid) {
		this.projid = projid;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	
	/*
	 * @JoinTable(name="join_student_project", joinColumns = @JoinColumn(name =
	 * "projid" , referencedColumnName = "projid" ), inverseJoinColumns
	 * = @JoinColumn(name = "id" , referencedColumnName = "id" ))
	 */
	@ManyToMany(fetch = FetchType.LAZY,mappedBy="project",targetEntity = Student.class, cascade = CascadeType.MERGE)
	public List<Student> getStudent() {
		return student;
	}

	@Override
	public String toString() {
		return "Project [projid=" + projid + ", projectname=" + projectname + ", duration=" + duration + ", Student="
				+ student + "]";
	}

	public Project(int projid, String projectname, String duration, List<Student> student) {
		super();
		this.projid = projid;
		this.projectname = projectname;
		this.duration = duration;
		student = student;
	}

	public void setStudent(List<Student> student) {
		student = student;
	}

}
