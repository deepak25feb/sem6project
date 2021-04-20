package com.example.demo.Authentication;

public class StudentAuthBuffer {
	
	private String studentemail;
	private String studentname;
	private String studentrollno;
	private String studentpassword;
	
	public StudentAuthBuffer() {
		super();
	}

	public StudentAuthBuffer(String studentemail, String studentname, String studentrollno, String studentpassword) {
		super();
		this.studentemail = studentemail;
		this.studentname = studentname;
		this.studentrollno = studentrollno;
		this.studentpassword = studentpassword;
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
		return "StudentAuthBuffer [studentemail=" + studentemail + ", studentname=" + studentname + ", studentrollno="
				+ studentrollno + ", studentpassword=" + studentpassword + "]";
	}
	
	

}
