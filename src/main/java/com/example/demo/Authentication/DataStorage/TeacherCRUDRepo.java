package com.example.demo.Authentication.DataStorage;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Authentication.EntitiesObjects.Teacher;

public interface TeacherCRUDRepo extends CrudRepository<Teacher, String> {
	
	public List<Teacher> findByEmail(String email);
	

}
