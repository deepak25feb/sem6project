package com.example.demo.Authentication.DataStorage;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.Authentication.EntitiesObjects.MarksOfStudent;

public interface MarksOfStudentCRUDRepo extends CrudRepository<MarksOfStudent, String>{

		@Query(value = "select * from marksofstudents",nativeQuery = true)
		List<MarksOfStudent> getAllStudentMarks();
}
