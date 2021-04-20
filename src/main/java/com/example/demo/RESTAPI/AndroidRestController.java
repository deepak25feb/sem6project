package com.example.demo.RESTAPI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Authentication.EntitiesObjects.QuestionPaper;
import com.example.demo.Authentication.EntitiesObjects.StudentAuth;
import com.example.demo.Authentication.EntitiesObjects.StudentFirstInput;

@RestController
public class AndroidRestController {
	
	String counterSaver;
	
	@Autowired
	private BusinessLayer businessLogic;
	
	
	@GetMapping("/oAuth")
	public Map<String,String> authenticateStudent(@RequestParam String Semail,@RequestParam String Temail,String pass) {
		Map<String,String> map = new HashMap<>();
		List<StudentAuth> student = businessLogic.getStudentAuth(Semail, Temail);
		if(student.isEmpty()) {
			//return false
			System.out.println("EMPTY");
			map.put("status", "failure");
			return map;
		}else if(businessLogic.authorizedOrNot(student, pass)) {
			int i = businessLogic.findQuestionPaperByTeacherEmailId(Temail);
			map.put("questionCount", String.valueOf(i));
			map.put("status", "success");
			System.out.println("Correct PASSWORD");
			return map;
			//password is correct
		}else {
			// return false -- password not correct
			System.out.println("WRONG PASSWORD");
			map.put("status", "failure");
			return map;
		}
		
		
	}
	
	@GetMapping("/getExamDetails")
	public Map<String,StudentFirstInput> getExamDetails(@RequestParam String Temail){
		Map<String,StudentFirstInput> map = new HashMap<>();
		List<StudentFirstInput> studentList= businessLogic.getExamDetailsInfo(Temail);
		StudentFirstInput student = studentList.get(0);
		
		map.put("examdetails", student);
		
		return map;
	}
	
	@GetMapping("/giveQuestionAndroid/{temail}/{id}")
	public  Map<String,QuestionPaper> sendQuestion(@PathVariable("temail") String temail,@PathVariable("id") String id){
		counterSaver = id;
		QuestionPaper quesPaper = businessLogic.getQuestionByIndex(temail,id);
		Map<String,QuestionPaper> map = new HashMap<>();
		map.put("question", quesPaper);
		return map;
	}
	
	@GetMapping("/persistAnsForAndroid/{temail}/{semail}")
	public Map<String,String> persistAndroidResponse(HttpServletRequest request,@PathVariable("temail") String temail,@PathVariable("semail") String semail) {
		Map<String,String> map = new HashMap<>();
		int quesCount = businessLogic.getQuestionCount(temail);
		String option = null;
		for(int i = 0 ; i<quesCount ; i++) {
			QuestionPaper quesPaper = businessLogic.getQuestionByIndex(temail,String.valueOf(i));
			String studentAnswer = (String)request.getParameter("option"+i);
			if(studentAnswer.equals(quesPaper.getqKaAresponse1())) {
				option = "1";
			}else if(studentAnswer.equals(quesPaper.getqKaAresponse2())) {
				option = "2";
			}else if(studentAnswer.equals(quesPaper.getqKaAresponse3())){
				option = "3";
			}else if(studentAnswer.equals(quesPaper.getqKaAresponse4())){
				option = "4";
			}
			businessLogic.saveAndroidAnswer(option,semail);
		}
		
//		String option = "0";
//		if(response.equals(quesPaper.getqKaAresponse1())) {
//			option = "1";
//		}else if(response.equals(quesPaper.getqKaAresponse2())) {
//			option = "2";
//		}else if(response.equals(quesPaper.getqKaAresponse3())){
//			option = "3";
//		}else if(response.equals(quesPaper.getqKaAresponse4())){
//			option = "4";
//		}
//		businessLogic.saveAndroidAnswer(option,semail);
		map.put("status", "Done");
		return map;
	}

}
