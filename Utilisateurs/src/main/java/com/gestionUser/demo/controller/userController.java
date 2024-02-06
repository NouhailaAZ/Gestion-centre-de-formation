package com.gestionUser.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.gestionUser.demo.entities.participant;
import com.gestionUser.demo.repository.userRepository;
import com.gestionUser.demo.service.userService;

@RestController
public class userController {
	@Autowired userService ser;
	@Autowired
	userRepository userRepository;
	@PostMapping("user/save")
	public String registerUser(@RequestBody participant p) {
		String email =p.getEmail();
		if(ser.isEmailUnique( email)) {
			ser.saveUser(p);
			
			return "User Saved";
		}
		else  
		{
			return " email not valid";
		}
		
	
	}
	@GetMapping("user/allUser")
	public List<participant> allUser(){
		return ser.allUser();
	}
	
	@GetMapping("participant/idParticipant/{idParticipant}")
	public Optional<participant> getUseById(@PathVariable Integer idParticipant){
		return ser.findById(idParticipant);
	}
	
	@GetMapping("idformation/{idformation}") 
	List<participant> getParticipantById(@PathVariable int idformation){
		List<participant> listParticipant= allUser();
		List<participant> listPart=new ArrayList() ;
		for(participant par:listParticipant) {
			if(par.getIdFormation() == idformation) {
				listPart.add(par);
			}
		}
		return listPart;
	}
	
	@PutMapping("user/updateUser/{id}")
	public String updateUser(@RequestBody participant e,@PathVariable Integer id) {
		if(ser.updateUser(e)) {
			return "L'utilisateur est bien modifié";
		}
		else {
		return "L'utilisateur n'existe pas";
		}
		
	}
	
	@DeleteMapping("user/deleteUser/{id}")
	public String deleteUser(@PathVariable Integer id) {
		if(ser.delete(id))
			return "La suppression est bien effectuée";
		return "L'utilisateur n'existe pas";
	
	}
    @GetMapping("hi")
    public String hi(){
        return "hi";
    }
}
