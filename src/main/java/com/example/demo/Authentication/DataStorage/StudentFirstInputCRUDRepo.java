package com.example.demo.Authentication.DataStorage;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Authentication.EntitiesObjects.StudentFirstInput;

public interface StudentFirstInputCRUDRepo extends CrudRepository<StudentFirstInput, String>{

	public List<StudentFirstInput> findByTemail(String temail);
}
