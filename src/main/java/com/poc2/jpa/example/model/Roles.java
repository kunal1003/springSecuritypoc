package com.poc2.jpa.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Roles {

	
	@Id
	/*4444444 @GeneratedValue */
	private int roleid;
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	private String role;
	

	public Roles() {}
	
	
	public Roles(int roleid, String role) {
		super();
		this.roleid = roleid;
		this.role = role;
	}
	
	
}
