package com.example.demo.Authentication.EntitiesObjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "teachers")
public class Teacher {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int index;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "password")
	private String password;
	
	public Teacher() {
		super();
	}

	public Teacher(int index, String email, String name, String password) {
		super();
		this.index = index;
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Teacher [index=" + index + ", email=" + email + ", name=" + name + ", password=" + password + "]";
	}
	
	
	

}
