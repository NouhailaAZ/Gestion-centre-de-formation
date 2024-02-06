package com.gestionUser.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionUser.demo.entities.formateur;
import com.gestionUser.demo.entities.participant;
import com.gestionUser.demo.repository.FormateurRepository;
import com.gestionUser.demo.service.FormateurService;
import com.gestionUser.demo.service.userService;

@RestController
@RequestMapping("formateur")
public class FormateurController {

	@Autowired
	FormateurService ser;
	@Autowired
	FormateurRepository repo;
	
	@GetMapping("{idFormateur}")
	public formateur getFormateurById(@PathVariable("idFormateur") int idFormateur) {
		return repo.findById(idFormateur).get();
	}
	
	@PostMapping("addFormateur")
	public String registerFormer(@RequestBody formateur p) {
		String email =p.getEmail();
		if(ser.isEmailUnique( email)) {
			ser.saveformer(p);
			
			return "Former Saved";
		}
		else  
		{
			return " email not valid";
		}
		
	
	}
	@GetMapping("allFormateur")
	public List<formateur> allFormer(){
		return ser.allFormer();
	}
	
	@PutMapping("updateFormateur/{id}")
	public String updateFormer(@RequestBody formateur e,@PathVariable Integer id) {
		if(ser.updateFormer(e)) {
			return "Le formateur est bien modifié";
		}
		else {
		return "Le formateur n'existe pas";
		}
		
	}
	
	@DeleteMapping("deleteFormateur/{id}")
	public String deleteFormer(@PathVariable Integer id) {
		if(ser.delete(id))
			return "La suppression est bien effectuée";
		return "Le formateur n'existe pas";
	
	}
}
