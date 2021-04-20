package com.example.demo.Authentication;

import org.springframework.stereotype.Component;

@Component
public class StudentFirstInputBuffer {
	
	private String subjectname;
	private String totalstudent;
	private String examdate;
	private String examtime;
	
	
	public StudentFirstInputBuffer() {
		super();
	}


	public StudentFirstInputBuffer(String subjectname, String totalstudent, String examdate, String examtime) {
		super();
		this.subjectname = subjectname;
		this.totalstudent = totalstudent;
		this.examdate = examdate;
		this.examtime = examtime;
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
		return "StudentFirstInputBuffer [subjectname=" + subjectname + ", totalstudent=" + totalstudent + ", examdate="
				+ examdate + ", examtime=" + examtime + "]";
	}
	
	
	

}
