package com.example.demo.Authentication.DataStorage;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Authentication.EntitiesObjects.StudentAuth;

public interface StrudentAuthCRUDRepo extends CrudRepository<StudentAuth, String>{
	
	public List<StudentAuth> findBytemailID(String temailID);
	
	public List<StudentAuth> findBytemailIDAndStudentemail(String temailID,String studentemail);
}
