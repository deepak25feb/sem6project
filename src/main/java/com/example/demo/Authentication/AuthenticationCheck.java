package com.example.demo.Authentication;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.example.demo.Authentication.DataStorage.AnswerofMockCRUDRepo;
import com.example.demo.Authentication.DataStorage.MarksOfStudentCRUDRepo;
import com.example.demo.Authentication.DataStorage.QuestionPaperCRUDRepo;
import com.example.demo.Authentication.DataStorage.StrudentAuthCRUDRepo;
import com.example.demo.Authentication.DataStorage.StudentFirstInputCRUDRepo;
import com.example.demo.Authentication.DataStorage.TeacherCRUDRepo;
import com.example.demo.Authentication.EntitiesObjects.AnswerofMocks;
import com.example.demo.Authentication.EntitiesObjects.MarksOfStudent;
import com.example.demo.Authentication.EntitiesObjects.QuestionPaper;
import com.example.demo.Authentication.EntitiesObjects.StudentAuth;
import com.example.demo.Authentication.EntitiesObjects.StudentFirstInput;
import com.example.demo.Authentication.EntitiesObjects.Teacher;

//This class will check whether USer is New or Not.
@Component
public class AuthenticationCheck {
	
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	TeacherCRUDRepo operation;
	
	@Autowired
	QuestionPaperCRUDRepo questionOperation;
	
	@Autowired
	StudentFirstInputCRUDRepo studentFirstRepo;
	
	@Autowired
	StrudentAuthCRUDRepo studentSecondRepo;
	
	@Autowired
	AnswerofMockCRUDRepo answerRepo;
	
	@Autowired
	MarksOfStudentCRUDRepo markCrudRepo;
	
	public AuthenticationCheck() {
		super();
	}

	public AuthenticationCheck(ApplicationContext context) {
		super();
		this.context = context;
	}


	
	public Boolean isEntityNew(Teacher t) {
		
		List<Teacher> list= operation.findByEmail(t.getEmail());
		for(Teacher local : list) {
			System.out.println(local.toString());
		}
		boolean newOrOldTeacher = list.isEmpty();
		System.out.println("BOOL VALUE : "+newOrOldTeacher);
		return newOrOldTeacher;
	}
	
	public Boolean persistEntity(Teacher t) {
		operation.save(t);
		return true;
	}

	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}
	
	public void createSession(Teacher t,HttpSession session) {
		session.setAttribute("name", t.getName());
		session.setAttribute("email", t.getEmail());
	}
	
	public Boolean checkPassword(Teacher t) {
		List<Teacher> list= operation.findByEmail(t.getEmail());
		Teacher localTeacher = list.get(0);
		if(t.getPassword().equals(localTeacher.getPassword())) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public Teacher helperMethodofTeacher(Teacher t) {
		List<Teacher> list= operation.findByEmail(t.getEmail());
		Teacher localTeacher = list.get(0);
		return localTeacher;
		
	}
	
	public Teacher findTeacherByEmailId(String email) {
		List<Teacher> list = operation.findByEmail(email);
		Teacher t = list.get(0);
		return t;
	}
	
	public boolean saveQuestion(QuestionPaper p) {
		questionOperation.save(p);
		return true;
	}
	
	public QuestionPaper specialHelperMethodForQuestionEntity(QuestionPaperBuffer buffer,QuestionPaper paperEntity , String mail) {
		paperEntity.setTemailID(mail);
		paperEntity.setqNumber(buffer.getqNumber());
		paperEntity.setqDNumber(buffer.getqDNumber());
		paperEntity.setqMaxMarks(buffer.getqMaxMarks());
		paperEntity.setqMaxTime(buffer.getqMaxTime());
		paperEntity.setqResponse(buffer.getqResponse());
		paperEntity.setOption(buffer.getOption());
		paperEntity.setqKaAresponse1(buffer.getqKaAresponse1());
		paperEntity.setqKaAresponse2(buffer.getqKaAresponse2());
		paperEntity.setqKaAresponse3(buffer.getqKaAresponse3());
		paperEntity.setqKaAresponse4(buffer.getqKaAresponse4());
		paperEntity.setStatus(buffer.getStatus());
		
		return paperEntity;
	}
	
	public List<QuestionPaper> findQuestionPaperByTeacherEmailId(String email) {
		List<QuestionPaper> list = questionOperation.findBytemailID(email);
		
		return list;
	}
	
	public StudentFirstInput studentFirstHelperMethod(String email,StudentFirstInputBuffer buffer,StudentFirstInput studentFirst) {
		studentFirst.setTemail(email);
		studentFirst.setSubjectname(buffer.getSubjectname());
		studentFirst.setTotalstudent(buffer.getTotalstudent());
		studentFirst.setExamdate(buffer.getExamdate());
		studentFirst.setExamtime(buffer.getExamtime());
		
		return studentFirst;
	}
	
	public boolean persistStudentFirstInput(StudentFirstInput s) {
		studentFirstRepo.save(s);
		return true;
	}
	
	
	public StudentAuth getStudentAuthObject(String email,StudentAuthBuffer buffer , StudentAuth studentSecond) {
		studentSecond.setTemailID(email);
		studentSecond.setStudentemail(buffer.getStudentemail());
		studentSecond.setStudentname(buffer.getStudentname());	
		studentSecond.setStudentrollno(buffer.getStudentrollno());
		studentSecond.setStudentpassword(buffer.getStudentpassword());
		return studentSecond;
	}
	
	public boolean persistStudentSecondInput(StudentAuth s) {
		studentSecondRepo.save(s);
		return true;
	}
	
	public List<StudentAuth> getStudentAuth(String email){
		List<StudentAuth> list = studentSecondRepo.findBytemailID(email);
		return list;
	}
	
	public List<StudentAuth> checkStudentDetails(String temail,String studentEmail){
		List<StudentAuth> list = studentSecondRepo.findBytemailIDAndStudentemail(temail, studentEmail);
		return list;
	}
	
	public StudentFirstInput getStudentFirstInput(String email) {
		List<StudentFirstInput> s = studentFirstRepo.findByTemail(email);
		StudentFirstInput a = s.get(0);
		return a;
	}
	
	public List<QuestionPaper> getAllQuestion(String TeacherEmail){
		List<QuestionPaper> list = questionOperation.findBytemailID(TeacherEmail);
		return list;
	}
	
	public void persistStudentAnswer(String studentname,String ans) {
		AnswerofMocks answer = new AnswerofMocks();
		answer.setStudentname(studentname);
		answer.setAns(ans);
		answerRepo.save(answer);
	}
	
	public List<AnswerofMocks> getAnswerList(){
		List<AnswerofMocks> mock = answerRepo.customSQLquery();
		return mock;
	}
	
	public List<StudentAuth> getStudentEmail(String TemailID){
		List<StudentAuth> list = studentSecondRepo.findBytemailID(TemailID);
		return list;
	}

	public List<AnswerofMocks> getAnswerSheet(String emailStudent) {
		List<AnswerofMocks> instanceofStudentMarks = answerRepo.findByStudentname(emailStudent);
		return instanceofStudentMarks;
	}
	
	public void persistStudentMarks(String temail , String studentemail , int marks) {
		MarksOfStudent marker = new MarksOfStudent();
		marker.setTeacheremail(temail);
		marker.setStudentemail(studentemail);
		marker.setMarks(marks);
		markCrudRepo.save(marker);
		
	}
	
	public List<MarksOfStudent> getStudentMarksfromDatabase(){
		List<MarksOfStudent> list = markCrudRepo.getAllStudentMarks();
		return list;
	}
	
}
