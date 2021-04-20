package com.example.demo.Authentication;



import java.awt.AWTException;

import java.io.IOException;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.RecordAndEncodeVideo;
import com.example.demo.Authentication.EntitiesObjects.AnswerofMocks;
import com.example.demo.Authentication.EntitiesObjects.MarksOfStudent;
import com.example.demo.Authentication.EntitiesObjects.QuestionPaper;
import com.example.demo.Authentication.EntitiesObjects.StudentAuth;
import com.example.demo.Authentication.EntitiesObjects.StudentFirstInput;
import com.example.demo.Authentication.EntitiesObjects.Teacher;
import com.example.demo.EmailClient.EmailSenderService;




//http://localhost:8080/webpages/homepage/home/index.html
@Controller()
public class AuthenticatorController {
	
	Teacher t;
	
	
	RecordAndEncodeVideo webCam;
	
	private static int editCounter=0;
	private static int editCounter1=0;
	private static int questionindex=0;
	
	private static int totalNumberOfStudentCount=0;
	private static int localcount = 1;
	
	@Autowired
	private AuthenticationCheck checker;
	
	@Autowired
	private EmailSenderService serviceEmail;
	
	@ResponseBody
	@PostMapping("/mapTeacher") //Signing a  teacher
	public List<String> mapTeacher(@RequestBody Teacher t,HttpServletRequest request) throws IOException {
		this.t=t;
		//Always ask new user true/false : true means new / false means old
		Boolean b = checker.isEntityNew(t);
		System.out.println("----------------SIGN IN -----------------------");
		System.out.println("Is Teacher New  : "+b);
		if(b) { 	//list is empty
			//persist Teacher Object.
			checker.persistEntity(t);
			HttpSession session = request.getSession();
			checker.createSession(t, session);
			System.out.println(t.getEmail()+" SESSION IS CREATED");
			return List.of("true");
		}else {
			//Email Id already Exists.
			System.out.println(t.getEmail()+":  INVALID RESPONSE ----Email Already Exists");
			return List.of("false");
		}
	
	}
	
	@GetMapping("/dashboard")  // Teacher is Genuine
	public String getTeacherDashboard(HttpServletRequest request) {
		//this get mapping will return dashboard Page
		HttpSession s = request.getSession(false);
		
		if(s!=null) {
			System.out.println("--------------------------LOGIN TO DASHBOARD------------------------");
			System.out.println("SIGN IN SUCESSFULL");
			return "dashboardTeacher";
		}else {
			System.out.println("SIGN IN UNSUCESSFULL--------SESSION DONT EXISTS");
			return "dashBoardError";
		}
		
	}
	
	@ResponseBody
	@PostMapping("/teacherLogin")
	public List<String> teacherLogin(@RequestBody Teacher t,HttpServletRequest request) throws IOException{
		boolean isNew = checker.isEntityNew(t);
		boolean passwordChecker = checker.checkPassword(t);
		Teacher tNew = checker.helperMethodofTeacher(t);
		System.out.println("------------------------- LOGIN -------------------------------");
		if(isNew) {
			System.out.println("EMAIL ID DONT EXISTS");
			return List.of("false");  //when session is not created hence error---->
		}else if(passwordChecker){  //Password is Correct
			HttpSession session = request.getSession();
			checker.createSession(tNew, session);
			System.out.println("VAILD"+tNew.getEmail()+" : Email ---------CREATING SESSION");
			return List.of("true");
		}else {
			System.out.println("VAILD"+tNew.getEmail()+" : Email BUT PASSWORD IS WRONG");
			return List.of("false");
		}
		
	}
	
	@GetMapping("/logoutSuccess")
	public String getLogoutPage() {
		return "logoutPage";
	}
	
	@GetMapping("/changeUsernameOfTeacher")
	public String changeTeacherUsename(HttpServletRequest request) throws IOException{
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			return "changeUsername";
		}else {
			return "dashBoardError";
		}
		
	}
	
	@GetMapping("/changeTeacherNameReal")
	public String changeTeacherNameReal(HttpServletRequest request,@RequestParam String username) throws IOException{
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			String emailId = (String)session.getAttribute("email");
			Teacher t = checker.findTeacherByEmailId(emailId);
			t.setName(username);
			checker.persistEntity(t);
			return "successChanges";
			
		}else {
			return "dashBoardError";
		}
		
	}
	
	@GetMapping("/changeEmailOfTeacher")
	public String changeTeacherEmail(HttpServletRequest request) throws IOException{
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			return "changeEmail";
		}else {
			return "dashBoardError";
		}
		
	}
	
	@GetMapping("/changeTeacherEmailReal")
	public String changeTeacherEmailReal(HttpServletRequest request,@RequestParam String email) throws IOException{
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			String emailId = (String)session.getAttribute("email");
			Teacher t = checker.findTeacherByEmailId(emailId);
			t.setEmail(email);
			checker.persistEntity(t);
			return "successChanges";
			
		}else {
			return "dashBoardError";
		}
		
	}
	
	
	@GetMapping("/changePasswordOfTeacher")
	public String changeTeacherPassword(HttpServletRequest request) throws IOException{
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			return "changePassword";
		}else {
			return "dashBoardError";
		}
		
	}
	
	@GetMapping("/changeTeacherPasswordReal")
	public String changeTeacherPasswordReal(HttpServletRequest request,@RequestParam String password) throws IOException{
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			String emailId = (String)session.getAttribute("email");
			Teacher t = checker.findTeacherByEmailId(emailId);
			t.setPassword(password);
			checker.persistEntity(t);
			return "successChanges";
			
		}else {
			return "dashBoardError";
		}
		
	}
	
	
	@GetMapping("/createMock")
	public String createQuestionPaper(HttpServletRequest request) throws IOException {
		HttpSession session = request.getSession(false);
		
		if(session!=null) {
			return "CreateMock";
		}else {
			return "dashBoardError";
		}
		
	}
	
	@GetMapping("/nextQuestionRequest")
	public String nextQuestionPaper(HttpServletRequest request,@ModelAttribute QuestionPaperBuffer buffer) throws IOException{
		HttpSession session = request.getSession(false);
		if(session !=null) {
			String mail = (String)session.getAttribute("email");
			QuestionPaper paper = new QuestionPaper();
			paper = checker.specialHelperMethodForQuestionEntity(buffer, paper, mail);
			checker.saveQuestion(paper);
			if((buffer.getStatus()).equals("true")){
				return "successChanges";
			}else {
				return "CreateMock";
			}
			
		}else {
			return null;
		}
		
		
	}
	
	
	@GetMapping("/editMock")
	public ModelAndView editMock(HttpServletRequest request)throws IOException {
		HttpSession session = request.getSession(false);
		ModelAndView m = new ModelAndView();
		QuestionPaper ques = new QuestionPaper();
		if(session !=null) {
			String mail = (String)session.getAttribute("email");
			List<QuestionPaper> q = checker.findQuestionPaperByTeacherEmailId(mail);
			try {
				 ques = q.get(editCounter);
			}catch (Exception e) {
//				m.setViewName("dashBoardError"); -- > Call persist
				editCounter=0;
				ques = q.get(editCounter);
			}
			
			
			System.out.println("COUNTER STATUS : "+editCounter);
			
//			for(QuestionPaper p:q) {
//				System.out.println(p.toString());
//			}
			m.addObject("object1", ques);
			System.out.println(ques.toString());
			
			m.setViewName("editMockPaper");
			editCounter++;
			return m;
		}else {
			m.setViewName("dashBoardError");
			return m;
		}
		
	}
	
	@GetMapping("/saveEditChanges")
	public String saveQuestionPaperEdit(HttpServletRequest request,@ModelAttribute QuestionPaperBuffer buffer)throws IOException {
		HttpSession session = request.getSession(false);
		if(session != null) {
			String mail = (String)session.getAttribute("email");
			QuestionPaper paper = new QuestionPaper();
			paper = checker.specialHelperMethodForQuestionEntity(buffer, paper, mail);
			checker.saveQuestion(paper);
			if((buffer.getStatus()).equals("true")){
				return "successChanges";
			}else {
				return "redirect:/editMock";
			}
		}else {
			return "dashBoardError";
		}
		
	}
	
	
	@GetMapping("/viewMock")
	public ModelAndView viewQuestionPaper(HttpServletRequest request) throws IOException{
		HttpSession session = request.getSession(false);
		QuestionPaper ques = new QuestionPaper();
		ModelAndView view = new ModelAndView();
		if(session !=null) {
			String mail = (String)session.getAttribute("email");
			List<QuestionPaper> q = checker.findQuestionPaperByTeacherEmailId(mail);
			try {
				 ques = q.get(editCounter1);
			}catch (Exception e) {
//				m.setViewName("dashBoardError"); -- > Call persist
				editCounter1=0;
				ques = q.get(editCounter1);
			}
			view.addObject("object2", ques);
			
			view.setViewName("viewMockPrepared");
			editCounter1++;
			return view;
		}else {
			view.setViewName("dashBoardError");
			return view;
		}
		
	}
	
	@GetMapping("/submitViewMock")
	public String submitViewMockPaper(HttpServletRequest request,@ModelAttribute QuestionPaperBuffer buffer)throws IOException {
		HttpSession session = request.getSession(false);
		if(session != null) {
			
			if((buffer.getStatus()).equals("true")){
				return "dashboardTeacher";
			}else {
				return "redirect:/viewMock";
			}
		}else {
			return "dashBoardError";
		}
		
	}
	
	@GetMapping("/createStudent")
	public String createStudentFallback(HttpServletRequest request) throws IOException {
		HttpSession session = request.getSession(false);
		if(session !=null) {
			return "createStudentFirstInput";
		}else {
			return "dashBoardError";
		}
		
	}
	
	@GetMapping("/persistStudentFistInput")
	public String persistStudentFistInput(HttpServletRequest request,@ModelAttribute StudentFirstInputBuffer buffer ) throws IOException {
		HttpSession session = request.getSession(false);
		if(session !=null) {
			String mail = (String)session.getAttribute("email");
			StudentFirstInput student = new StudentFirstInput();
			student = checker.studentFirstHelperMethod(mail, buffer, student);
			//persist student
			totalNumberOfStudentCount =Integer.parseInt(buffer.getTotalstudent());
			checker.persistStudentFirstInput(student);
			return "studentAuthenticationValues";
		}else {
			return "dashBoardError";
		}
		
	}
	
	@GetMapping("/AddStudentInstance")
	public String addStudentAuthInstance(HttpServletRequest request,@ModelAttribute StudentAuthBuffer buffer) throws IOException{
		HttpSession session = request.getSession(false);
		
		if(session !=null) {
			//persist buffer with teacher email
			String mail = (String)session.getAttribute("email");
			StudentAuth studentPersist = new StudentAuth();
			studentPersist = checker.getStudentAuthObject(mail, buffer, studentPersist);
			checker.persistStudentSecondInput(studentPersist);
			System.out.println("localcount : " + localcount);
			System.out.println("totalNumberOfStudentCount : " + totalNumberOfStudentCount);
			System.out.println(buffer.toString());
			if(localcount<totalNumberOfStudentCount) {
				localcount++;
				return "studentAuthenticationValues";
			}else {
				
				return "successChanges";
			}
			
		}else {
			return "dashBoardError";
		}
		
	}
	
	@GetMapping("/sendStudentInvite")
	public ModelAndView sendStudentsInvite(HttpServletRequest request)  throws IOException{
		ModelAndView m = new ModelAndView();
		HttpSession session = request.getSession(false);
		if(session !=null) {
			String mail = (String)session.getAttribute("email");
			List<StudentAuth> list = checker.getStudentAuth(mail);
			for(StudentAuth a : list) {
				System.out.println(a.toString());
			}
			m.addObject("studentauth", list);
			m.setViewName("studentAuthViewer");
			return m;
		}else {
			m.setViewName("dashBoardError");
			return m;
		}
		
		
	}
	
	@GetMapping("/sendAllStudentMail")
	public String sendAllStudentwithMail(HttpServletRequest request)  throws IOException{
		HttpSession session = request.getSession(false);
		if(session !=null) {
			String mail = (String)session.getAttribute("email");
			List<StudentAuth> list = checker.getStudentAuth(mail);
			for(StudentAuth a : list) {
				System.out.println(a.toString());
				serviceEmail.sendSimpleEmail(a.getStudentemail(), "YOUR EXAM IS BIENG SCHEDULED.\nYOUR CREDENTIALS ARE AS FOLLOW -\n"+"NAME : "+a.getStudentname()+"\nPASSWORD : "+a.getStudentpassword()+"\nROLL NO : "+a.getStudentrollno()+"\nDATE AND TIMING WILL BE INTIMATED BY THE CONCERNED AUTHORTY LATER", "ONLINE EXAM-THRIVE");
			}
			
			
			return "successChanges";
		}else {
			return "dashBoardError";
		}
	}
	
	@GetMapping("/AuthenticateStudent")
	public ModelAndView authenticateStudent(HttpServletRequest request,@RequestParam String studentemail,@RequestParam String teacheremail,@RequestParam String password) {
		List<StudentAuth> s = checker.checkStudentDetails(teacheremail, studentemail);
		ModelAndView model = new ModelAndView();		
		if(s.isEmpty()) {
			model.setViewName("dashBoardError");
			return model;
			//return eroor
		}else{
			StudentAuth student = s.get(0);
			if((student.getStudentemail().equals(studentemail))&&(student.getStudentpassword()).equals(password)) {
				//login
				
				System.out.println("CORRECT CREDENTIAL");
				StudentFirstInput testdetails =  checker.getStudentFirstInput(teacheremail);
				model.addObject("studenttestdetails", testdetails);
				model.setViewName("StudentDashboard");
				HttpSession session =  request.getSession();
				session.setAttribute("studentobject", testdetails);
				session.setAttribute("studentemail", studentemail);
				session.setAttribute("counter", 0);
				session.setAttribute("teachername", teacheremail );
				List<QuestionPaper> list = checker.getAllQuestion(teacheremail);
				int i = 0;
				for(QuestionPaper p:list) {
					 i = i + Integer.parseInt(p.getqMaxTime());
					 System.out.println("NUMBER : "+i);
				}
				webCam = new RecordAndEncodeVideo();
				try {
					webCam.mainMethod(i*60, 5, studentemail);
				} catch (InterruptedException | IOException | AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				return model;
			}else {
				//wrong credential
				model.setViewName("dashBoardError");
				return model;
			}
		}
//		
//		if(student !=null ||student.getStudentemail())
		
	}
	
	@GetMapping("/giveExam")
	public ModelAndView giveStudentExam(HttpServletRequest request)  throws IOException{
		HttpSession session = request.getSession(false);
		ModelAndView model = new ModelAndView();
		
		if(session !=null) {
			String teachermail = (String)session.getAttribute("teachername");
			List<QuestionPaper> list = checker.getAllQuestion(teachermail);
			
			int counterVar = (Integer)session.getAttribute("counter");
			System.out.println(list.size() +" "+questionindex);
			if(list.size()>counterVar) {
				QuestionPaper questionIndex = list.get(counterVar);
				model.setViewName("studentExamRealTime");
				model.addObject("questionpaper", questionIndex);
				counterVar++;
				session.setAttribute("counter", counterVar);
				return model;
			}else {
				model.setViewName("successChanges");
				return model;
			}
			
		}else {
			model.setViewName("dashBoardError");
			return model;
		}
	}
	
	@GetMapping("takeAnswer")
	public String persistAnswer(@RequestParam String option , HttpServletRequest request)  throws IOException{
		HttpSession session = request.getSession(false);
		if(session !=null) {
			 String studentEmail= (String)session.getAttribute("studentemail");
			 checker.persistStudentAnswer(studentEmail,option);
			 return "redirect:/giveExam";
		}else {
			return "dashBoardError";
		}
		
	}
	
	@GetMapping("/proctor")
	public ModelAndView showProcVid(HttpServletRequest request)  throws IOException{
		HttpSession session = request.getSession(false);
		ModelAndView model = new ModelAndView();
		if(session !=null) {
			String temail  = (String)session.getAttribute("email");
			List<StudentAuth> students = checker.getStudentAuth(temail);
			model.setViewName("showProctor");
			model.addObject("StudentEmailData", students);
			return model;
		}else {
			model.setViewName("dashBoardError");
			return model;
		}
		
	}
	
	@GetMapping("/showResult")
	public ModelAndView showResult(HttpServletRequest request)  throws IOException{
		HttpSession session = request.getSession(false);
		ModelAndView model = new ModelAndView();
		if(session !=null) {
			String Temail = (String)session.getAttribute("email");
			List<QuestionPaper> question = checker.findQuestionPaperByTeacherEmailId(Temail); //get Question Data
			List<StudentAuth> studentEmailID = checker.getStudentEmail(Temail);
			
			AnswerofMocks oneStudentAns = null;
			for(StudentAuth student : studentEmailID ) {
				String studentEmail = student.getStudentemail();
				List<AnswerofMocks> listofAnsByAStudent = checker.getAnswerSheet(studentEmail);
				int marks = 0;
				for(int i = 0 ; i < listofAnsByAStudent.size() ; i++) {
					oneStudentAns = listofAnsByAStudent.get(i);
					QuestionPaper questionOptionAns = question.get(i%3);
					System.out.println("STUDENT EMAIL : "+oneStudentAns.getStudentname()+" STUDENT Ans response : "+oneStudentAns.getAns()+"  : Correct Ans"+questionOptionAns.getOption());
					int studentresponse = Integer.parseInt(oneStudentAns.getAns());
					int correctresponse = Integer.parseInt(questionOptionAns.getOption());
					if(studentresponse == correctresponse) {
						marks++;
					}
				}
				System.out.println("------------PERSIST-----------------\n"+oneStudentAns.getStudentname()+" :  MARKS : "+marks);
				//session.setAttribute(oneStudentAns.getStudentname(), marks);
				checker.persistStudentMarks(Temail, oneStudentAns.getStudentname(), marks);
				
				
//				for(AnswerofMocks oneStudentAns : listofAnsByAStudent) {
//					for(QuestionPaper q : question){
//						System.out.println(q.getqNumber());
//						
//					}
//					System.out.println(oneStudentAns.toString());
//					break;
//				}
			}
			
			List<MarksOfStudent> list = checker.getStudentMarksfromDatabase();
			model.setViewName("showResult");
			model.addObject("studentresult", list);
			//session.setAttribute("listItems", list);
			return model;
		}else {
			model.setViewName("dashBoardError");
			return model;
		}
		
		
		
	}
	
	
	@GetMapping("/goto")
	public ModelAndView getAI(@RequestParam String id , HttpServletRequest request)  throws IOException{
		HttpSession session = request.getSession(false);
		ModelAndView model = new ModelAndView();
		if(session !=null) {
			model.setViewName("showAIProctor");
			model.addObject("emailIdofStudentProc",id);
			return model;
		}else {
			model.setViewName("dashBoardError");
			return model;
		}
		
	}
	
	@GetMapping("checkCompatibility")
	public String checkCompatibility() {
		return "checkComp";
	}
	
	
	

}
