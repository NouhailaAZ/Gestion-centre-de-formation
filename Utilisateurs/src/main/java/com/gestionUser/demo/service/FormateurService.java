package com.gestionUser.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionUser.demo.entities.formateur;
import com.gestionUser.demo.entities.participant;
import com.gestionUser.demo.repository.FormateurRepository;

@Service
public class FormateurService {

	@Autowired
	FormateurRepository repo;
public boolean isEmailUnique(  String  email) {
		
		formateur p =  repo.findByEmail(email);
		return p ==null ;
	}
	
	public boolean findById(Integer i) {
		if(repo.findById(i) != null)
			return true;
		return false;
	}
	
	public void saveformer(formateur p) {
	
		//encodePassworrd(p);
		repo.save(p);
		
	}
	
	public List<formateur> allFormer(){
		return (List<formateur>) repo.findAll();
	}
	
	public boolean updateFormer(formateur e) {
		Optional<formateur> pr = repo.findById(e.getId());
		if(pr.isPresent()) {
			formateur p = pr.get();
			p.setEmail(e.getEmail());
			p.setNom(e.getNom());
			p.setAge(e.getAge());
			p.setPrennom(e.getPrennom());
			p.setSalaire(e.getSalaire());
			p.setSpecialité(e.getSpecialité());
			p.setTelephone(e.getTelephone());
			p.setPassword(e.getPassword());
			repo.save(p);
			return true;
		}
		return false;
		
	}
	
	public boolean delete(Integer i) {
		if(repo.existsById(i)) {
			repo.deleteById(i);
			return true;
		}
		return false;
		
	}
}
