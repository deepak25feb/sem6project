package com.example.demo.Authentication.EntitiesObjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "examdetails")
public class StudentFirstInput {
	@Id
	@Column(name = "temail")
	private String temail;
	
	@Column(name = "subjectname")
	private String subjectname;
	
	@Column(name = "totalstudent")
	private String totalstudent;
	
	@Column(name = "examdate")
	private String examdate;
	
	@Column(name = "examtime")
	private String examtime;

	public StudentFirstInput() {
		super();
	}

	public StudentFirstInput(String temail, String subjectname, String totalstudent, String examdate, String examtime) {
		super();
		this.temail = temail;
		this.subjectname = subjectname;
		this.totalstudent = totalstudent;
		this.examdate = examdate;
		this.examtime = examtime;
	}

	public String getTemail() {
		return temail;
	}

	public void setTemail(String temail) {
		this.temail = temail;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public String getTotalstudent() {
		return totalstudent;
	}

	public void setTotalstudent(String totalstudent) {
		this.totalstudent = totalstudent;
	}

	public String getExamdate() {
		return examdate;
	}

	public void setExamdate(String examdate) {
		this.examdate = examdate;
	}

	public String getExamtime() {
		return examtime;
	}

	public void setExamtime(String examtime) {
		this.examtime = examtime;
	}

	@Override
	public String toString() {
		return "StudentFirstInput [temail=" + temail + ", subjectname=" + subjectname + ", totalstudent=" + totalstudent
				+ ", examdate=" + examdate + ", examtime=" + examtime + "]";
	}
	
	
	
	
	
}
