package com.fsts.formation.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsts.formation.entities.Formation;
import com.fsts.formation.feign.FeignUtilisateur;
import com.fsts.formation.model.Formateur;
import com.fsts.formation.model.Participant;
import com.fsts.formation.repositories.FormationReposity;

import jakarta.persistence.EntityNotFoundException;
import jakarta.ws.rs.NotFoundException;

@RestController
//@RequestMapping("formation")
public class FormationController {
	@Autowired
	FormationReposity formationRepositories;
	@Autowired
	FeignUtilisateur feignUtilisateur;
	
	//Afficher une formation avec son formateur
	@GetMapping("/formation/{idFormation}")
	public Formation getformationById(@PathVariable Integer idFormation){
		Formation formation = formationRepositories.findById(idFormation).orElse(null);
		if(formation!= null) {
			Formateur formateur = feignUtilisateur.getFormateurById(formation.getIdFormateur());
			formation.setFormateur(formateur);
		}
		
		return formation;
	}
	
	//Creation d'une formation
	@PostMapping("/createFormation")
	public ResponseEntity<Formation> save(@RequestBody Formation formation) throws NotFoundException {
		Formateur formateur = feignUtilisateur.getFormateurById(formation.getIdFormateur());
		if(formateur != null)
		{  
			Formation form = formationRepositories.save(formation);
			return new ResponseEntity<>(form,HttpStatus.CREATED); 
			
		}
		else 
		{
			 throw new EntityNotFoundException("Formateur  Not found");
		}
	
	}
	
	//Modifer une formation
	@PutMapping("updateFormation")
	public ResponseEntity<Formation> update(@RequestBody Formation formation) throws NotFoundException
	{
		Optional<Formation> optional =  formationRepositories.findById(formation.getIdFormation());
		if(optional.isEmpty())
		{
			throw new EntityNotFoundException("Formation  Not Exist"); 
		}
		
		else 
		{
			Formateur c = feignUtilisateur.getFormateurById(formation.getIdFormateur());
			if(c!=null)
			{
			    Formation fr=formationRepositories.save(formation);
				return ResponseEntity.accepted().body(fr);
			}
		}
		throw new EntityNotFoundException("Formateur  Not found");
	}
	
	//Supprimer une formation
	@DeleteMapping("/idFormation/{idFormation}")
	public ResponseEntity<Formation> delete(@PathVariable Integer idFormation) {
		formationRepositories.deleteById(idFormation);
		return ResponseEntity.noContent().build();
	}
	
	//Afficher tous les formations
	@GetMapping("allFormations")
	public List<Formation> listFormation()
	{
		return formationRepositories.findAll();
	}
	
	//Afficher les formations d'un formateur
	@GetMapping("/idFormateur/{idFormateur}")
	public List<Formation> listFormationByIdFormateur(@PathVariable Integer idFormateur)
	{
		List<Formation> listFormation = formationRepositories.findAll();
		List<Formation> AllFormationFormateur = new ArrayList() ;
		for(Formation formation : listFormation) {
			if(formation.getIdFormateur() == idFormateur) {
				AllFormationFormateur.add(formation);
			}
		}
		return AllFormationFormateur;
	}
	
	//list les Participant d'un formation
	@GetMapping("/FormationsByIdParticipant/{idFormation}")
    public List<Participant> getParticipantsByFormationId(@PathVariable int idFormation) {
       
    	return feignUtilisateur.getParticipantById(idFormation);
    }
	
	
}
