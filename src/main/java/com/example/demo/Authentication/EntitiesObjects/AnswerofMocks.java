package com.example.demo.Authentication.EntitiesObjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="answer")
public class AnswerofMocks {
	
	@Column(name="student")
	String studentname;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="answer")
	private String ans;
	

	public AnswerofMocks() {
		super();
	}


	public AnswerofMocks(String studentname, int id, String ans) {
		super();
		this.studentname = studentname;
		this.id = id;
		this.ans = ans;
	}


	public String getStudentname() {
		return studentname;
	}


	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAns() {
		return ans;
	}


	public void setAns(String ans) {
		this.ans = ans;
	}


	@Override
	public String toString() {
		return "AnswerofMocks [studentname=" + studentname + ", id=" + id + ", ans=" + ans + "]";
	}


	
	
	
	
	
}
