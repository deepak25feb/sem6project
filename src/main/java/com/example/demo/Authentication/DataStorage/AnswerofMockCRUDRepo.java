package com.example.demo.Authentication.DataStorage;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.Authentication.EntitiesObjects.AnswerofMocks;


public interface AnswerofMockCRUDRepo extends CrudRepository<AnswerofMocks, String> {
	
	@Query(value="select * from answer",nativeQuery = true)
	public List<AnswerofMocks> customSQLquery();
	
	public List<AnswerofMocks> findByStudentname(String studentname);
}
