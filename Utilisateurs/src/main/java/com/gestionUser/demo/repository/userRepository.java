package com.gestionUser.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.gestionUser.demo.entities.formateur;
import com.gestionUser.demo.entities.participant;
import java.util.List;


public interface userRepository  extends CrudRepository<participant, Integer>{

		participant findByEmail(String email);
		
}
