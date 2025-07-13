package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.Entity.CrudEntity;
import com.crud.repository.CrudRepository;

@Service
public class CrudService {
	
	@Autowired
	CrudRepository crudRepository;
	 
	public CrudEntity saveCrud(CrudEntity crudEntity) {
	   return crudRepository.save(crudEntity);
	}

	
	// get all data service logic
	public List<CrudEntity> getAllDetails() {
		return crudRepository.findAll();
	}


	public void deleteById(Long id) {
		crudRepository.deleteById(id);
	}


	public CrudEntity getById(Long id) {
		return crudRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
		
	}

}
