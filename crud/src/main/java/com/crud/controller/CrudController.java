package com.crud.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crud.Entity.CrudEntity;
import com.crud.service.CrudService;

@Controller
public class CrudController {
	
	@Autowired
	CrudService crudService;
	
// -------------------------------------------------------------
	@GetMapping("/crud")
	public String colletCrud(Model model) {
		model.addAttribute("crudEntity", new CrudEntity());
		return "Crud";
	}

	@PostMapping("/crud/save")
	public String saveCrud(@ModelAttribute CrudEntity crudEntity) {
		crudService.saveCrud(crudEntity);
		return "redirect:/alldetails";
	}
	//---------------------------------------------------------------------
	
	
	
	// getting the all data	
	@GetMapping("/alldetails")
	public String getAllDetails(Model model){
		model.addAttribute("data", crudService.getAllDetails());
		return "data";
	}
	
	// edit the data
	@GetMapping("/alldetails/edit/{id}")
	public String editData(@PathVariable Long id, Model model) {
		model.addAttribute("crudEntity", crudService.getById(id));
		return "edit";
		
	}
	
	@PostMapping("/alldetails/edit/{id}")
	public String editDetails(@PathVariable Long id, @ModelAttribute("crudEntity") CrudEntity crudEntity) {
		
		CrudEntity existingCrudEntity = crudService.getById(id);
		existingCrudEntity.setName(crudEntity.getName());
		existingCrudEntity.setMovieName(crudEntity.getMovieName());
		existingCrudEntity.setMovieDate(crudEntity.getMovieDate());
		existingCrudEntity.setMovieTime(crudEntity.getMovieTime());
		existingCrudEntity.setAdditionalOptions(crudEntity.getAdditionalOptions());
		existingCrudEntity.setPaymentType(crudEntity.getPaymentType());
		crudService.saveCrud(existingCrudEntity);
		return "redirect:/alldetails";
	}
	
	
	
	// delete by id 
	@GetMapping("/alldetails/delete/{id}")
	public String deleteById(@PathVariable Long id) {
		crudService.deleteById(id);
		return "redirect:/alldetails";	
	}
}
