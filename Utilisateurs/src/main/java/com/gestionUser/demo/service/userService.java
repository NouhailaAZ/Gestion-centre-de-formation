package com.gestionUser.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.gestionUser.demo.entities.participant;
import com.gestionUser.demo.repository.userRepository;


@Service
public class userService {

	@Autowired userRepository repo;
	
	
	public boolean isEmailUnique(  String  email) {
		
		participant p =  repo.findByEmail(email);
		return p ==null ;
	}
	
	
	  public Optional<participant> findById(Integer i) 
	  { 
		  return repo.findById(i); 
	  }
	 
	
	public void saveUser(participant p) {
	
		//encodePassworrd(p);
		repo.save(p);
		
	}
	
	public List<participant> allUser(){
		return (List<participant>) repo.findAll();
	}
	
	public boolean updateUser(participant e) {
		Optional<participant> pr = repo.findById(e.getId());
		if(pr.isPresent()) {
			participant p = pr.get();
			p.setEmail(e.getEmail());
			p.setNom(e.getNom());
			p.setPass(e.getPass());
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
	/*public void encodePassworrd(participant c)
	{
		String passEncoder = pasEn.encode(c.getPass());
		c.setPass(passEncoder);
	}
	*/
}
