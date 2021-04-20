package com.example.demo.RESTAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Authentication.DataStorage.AnswerofMockCRUDRepo;
import com.example.demo.Authentication.DataStorage.QuestionPaperCRUDRepo;
import com.example.demo.Authentication.DataStorage.StrudentAuthCRUDRepo;
import com.example.demo.Authentication.DataStorage.StudentFirstInputCRUDRepo;
import com.example.demo.Authentication.EntitiesObjects.AnswerofMocks;
import com.example.demo.Authentication.EntitiesObjects.QuestionPaper;
import com.example.demo.Authentication.EntitiesObjects.StudentAuth;
import com.example.demo.Authentication.EntitiesObjects.StudentFirstInput;


@Component
public class BusinessLayer {
	
	@Autowired
	private StrudentAuthCRUDRepo authCrudREPO;
	
	@Autowired
	private StudentFirstInputCRUDRepo getExamDetailsCrudRepo;
	
	@Autowired
	QuestionPaperCRUDRepo questionOperation;
	
	@Autowired
	AnswerofMockCRUDRepo answerCrudREPO;

	public BusinessLayer() {
		super();
	}
	
	public List<StudentAuth> getStudentAuth(String Semail,String Temail){
		List<StudentAuth> list = authCrudREPO.findBytemailIDAndStudentemail(Temail,Semail);
		return list;
	}
	
	public boolean authorizedOrNot(List<StudentAuth> students,String password) {
		StudentAuth student = students.get(0);
		System.out.println("STUDENT REQUESTED : "+student.toString());
		System.out.println("STUDENT REAL PASS : "+student.getStudentpassword()+" : GIVEN PASSWORD : "+password);
		boolean result = (student.getStudentpassword()).equals(password); 
		System.out.println("result : "+result);
		return result; //true - then password is correct
	}
	
	public List<StudentFirstInput> getExamDetailsInfo(String temail){
		List<StudentFirstInput> list = getExamDetailsCrudRepo.findByTemail(temail);
		return list;
	}
	
	public int findQuestionPaperByTeacherEmailId(String email) {
		List<QuestionPaper> list = questionOperation.findBytemailID(email);
		return list.size();
	}
	
	public QuestionPaper getQuestionByIndex(String email,String index) {
		List<QuestionPaper> list = questionOperation.findBytemailID(email);
		return list.get(Integer.parseInt(index));
	}
	public int getQuestionCount(String email) {
		List<QuestionPaper> list = questionOperation.findBytemailID(email);
		return list.size();
	}
	public void saveAndroidAnswer(String option,String semail) {
		AnswerofMocks answer = new AnswerofMocks();
		answer.setAns(option);
		answer.setStudentname(semail);
		answerCrudREPO.save(answer);
		
	}

}
