package com.example.demo.Authentication.EntitiesObjects;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "questionpapermock")
public class QuestionPaper {
	
	@Column(name = "teacheremail")
	private String temailID;
	
	@Id
	@Column(name = "qnumber")
	private String qNumber;
	
	@Column(name = "qdnumber")
	private String qDNumber;
	
	@Column(name = "qmaxmarks")
	private String qMaxMarks;
	
	@Column(name = "qmaxtime")
	private String qMaxTime;
	
	@Column(name = "qresponse")
	private String qResponse;
	
	@Column(name = "options")
	private String option;
	
	@Column(name = "qkaaresponse1")
	private String qKaAresponse1;
	
	@Column(name = "qkaaresponse2")
	private String qKaAresponse2;
	
	@Column(name = "qkaaresponse3")
	private String qKaAresponse3;
	
	@Column(name = "qkaaresponse4")
	private String qKaAresponse4;
	
	@Column(name = "status")
	private String status;
	
	
	

	public QuestionPaper() {
		super();
	}




	public QuestionPaper(String temailID, String qNumber, String qDNumber, String qMaxMarks, String qMaxTime,
			String qResponse, String option, String qKaAresponse1, String qKaAresponse2, String qKaAresponse3,
			String qKaAresponse4, String status) {
		super();
		this.temailID = temailID;
		this.qNumber = qNumber;
		this.qDNumber = qDNumber;
		this.qMaxMarks = qMaxMarks;
		this.qMaxTime = qMaxTime;
		this.qResponse = qResponse;
		this.option = option;
		this.qKaAresponse1 = qKaAresponse1;
		this.qKaAresponse2 = qKaAresponse2;
		this.qKaAresponse3 = qKaAresponse3;
		this.qKaAresponse4 = qKaAresponse4;
		this.status = status;
	}




	public String getTemailID() {
		return temailID;
	}




	public void setTemailID(String temailID) {
		this.temailID = temailID;
	}




	public String getqNumber() {
		return qNumber;
	}




	public void setqNumber(String qNumber) {
		this.qNumber = qNumber;
	}




	public String getqDNumber() {
		return qDNumber;
	}




	public void setqDNumber(String qDNumber) {
		this.qDNumber = qDNumber;
	}




	public String getqMaxMarks() {
		return qMaxMarks;
	}




	public void setqMaxMarks(String qMaxMarks) {
		this.qMaxMarks = qMaxMarks;
	}




	public String getqMaxTime() {
		return qMaxTime;
	}




	public void setqMaxTime(String qMaxTime) {
		this.qMaxTime = qMaxTime;
	}




	public String getqResponse() {
		return qResponse;
	}




	public void setqResponse(String qResponse) {
		this.qResponse = qResponse;
	}




	public String getOption() {
		return option;
	}




	public void setOption(String option) {
		this.option = option;
	}




	public String getqKaAresponse1() {
		return qKaAresponse1;
	}




	public void setqKaAresponse1(String qKaAresponse1) {
		this.qKaAresponse1 = qKaAresponse1;
	}




	public String getqKaAresponse2() {
		return qKaAresponse2;
	}




	public void setqKaAresponse2(String qKaAresponse2) {
		this.qKaAresponse2 = qKaAresponse2;
	}




	public String getqKaAresponse3() {
		return qKaAresponse3;
	}




	public void setqKaAresponse3(String qKaAresponse3) {
		this.qKaAresponse3 = qKaAresponse3;
	}




	public String getqKaAresponse4() {
		return qKaAresponse4;
	}




	public void setqKaAresponse4(String qKaAresponse4) {
		this.qKaAresponse4 = qKaAresponse4;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	@Override
	public String toString() {
		return "QuestionPaper [temailID=" + temailID + ", qNumber=" + qNumber + ", qDNumber=" + qDNumber
				+ ", qMaxMarks=" + qMaxMarks + ", qMaxTime=" + qMaxTime + ", qResponse=" + qResponse + ", option="
				+ option + ", qKaAresponse1=" + qKaAresponse1 + ", qKaAresponse2=" + qKaAresponse2 + ", qKaAresponse3="
				+ qKaAresponse3 + ", qKaAresponse4=" + qKaAresponse4 + ", status=" + status + "]";
	}





	
	


}
