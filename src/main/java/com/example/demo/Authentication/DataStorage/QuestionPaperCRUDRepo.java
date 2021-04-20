package com.example.demo.Authentication.DataStorage;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Authentication.EntitiesObjects.QuestionPaper;


public interface QuestionPaperCRUDRepo extends CrudRepository<QuestionPaper, String>{
	
	public List<QuestionPaper> findBytemailID(String temailID);
	
}
