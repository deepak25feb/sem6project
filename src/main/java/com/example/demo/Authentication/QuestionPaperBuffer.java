package com.example.demo.Authentication;

import org.springframework.stereotype.Component;

@Component
public class QuestionPaperBuffer {
	
	private String qNumber;
	
	
	private String qDNumber;
	
	
	private String qMaxMarks;
	
	
	private String qMaxTime;
	

	private String qResponse;
	

	private String option;
	
	
	private String qKaAresponse1;
	
	
	private String qKaAresponse2;
	

	private String qKaAresponse3;
	

	private String qKaAresponse4;
	

	private String status;
	
	


	public QuestionPaperBuffer() {
		super();
	}




	public QuestionPaperBuffer(String qNumber, String qDNumber, String qMaxMarks, String qMaxTime, String qResponse,
			String option, String qKaAresponse1, String qKaAresponse2, String qKaAresponse3, String qKaAresponse4,
			String status) {
		super();
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
		return "QuestionPaperBuffer [qNumber=" + qNumber + ", qDNumber=" + qDNumber + ", qMaxMarks=" + qMaxMarks
				+ ", qMaxTime=" + qMaxTime + ", qResponse=" + qResponse + ", option=" + option + ", qKaAresponse1="
				+ qKaAresponse1 + ", qKaAresponse2=" + qKaAresponse2 + ", qKaAresponse3=" + qKaAresponse3
				+ ", qKaAresponse4=" + qKaAresponse4 + ", status=" + status + "]";
	}
	
	
	

}
