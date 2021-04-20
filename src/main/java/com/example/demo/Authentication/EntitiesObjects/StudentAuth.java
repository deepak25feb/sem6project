package com.example.demo.Authentication.EntitiesObjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="studentauthentication")
public class StudentAuth {
	@Column(name = "temailid")
	private String temailID;
	
	@Column(name = "studentemail")
	private String studentemail;
	
	@Column(name = "studentname")
	private String studentname;
	
	@Id
	@Column(name = "studentrollno")
	private String studentrollno;
	
	@Column(name = "studentpassword")
	private String studentpassword;
	
	

	public StudentAuth() {
		super();
	}



	public StudentAuth(String temailID, String studentemail, String studentname, String studentrollno,
			String studentpassword) {
		super();
		this.temailID = temailID;
		this.studentemail = studentemail;
		this.studentname = studentname;
		this.studentrollno = studentrollno;
		this.studentpassword = studentpassword;
	}



	public String getTemailID() {
		return temailID;
	}



	public void setTemailID(String temailID) {
		this.temailID = temailID;
	}



	public String getStudentemail() {
		return studentemail;
	}



	public void setStudentemail(String studentemail) {
		this.studentemail = studentemail;
	}



	public String getStudentname() {
		return studentname;
	}



	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}



	public String getStudentrollno() {
		return studentrollno;
	}



	public void setStudentrollno(String studentrollno) {
		this.studentrollno = studentrollno;
	}



	public String getStudentpassword() {
		return studentpassword;
	}



	public void setStudentpassword(String studentpassword) {
		this.studentpassword = studentpassword;
	}



	@Override
	public String toString() {
		return "StudentAuth [temailID=" + temailID + ", studentemail=" + studentemail + ", studentname=" + studentname
				+ ", studentrollno=" + studentrollno + ", studentpassword=" + studentpassword + "]";
	}
	
	
	
	

}
