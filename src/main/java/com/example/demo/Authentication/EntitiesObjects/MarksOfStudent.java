package com.example.demo.Authentication.EntitiesObjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="marksofstudents")
public class MarksOfStudent {
	
	@Column(name = "teacheremail")
	private String teacheremail;
	
	@Id
	@Column(name="studentemail")
	private String studentemail;
	
	@Column(name="marks")
	private int marks;

	public MarksOfStudent() {
		super();
	}

	public MarksOfStudent(String teacheremail, String studentemail, int marks) {
		super();
		this.teacheremail = teacheremail;
		this.studentemail = studentemail;
		this.marks = marks;
	}

	public String getTeacheremail() {
		return teacheremail;
	}

	public void setTeacheremail(String teacheremail) {
		this.teacheremail = teacheremail;
	}

	public String getStudentemail() {
		return studentemail;
	}

	public void setStudentemail(String studentemail) {
		this.studentemail = studentemail;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "MarksOfStudent [teacheremail=" + teacheremail + ", studentemail=" + studentemail + ", marks=" + marks
				+ "]";
	}
	
	

}
