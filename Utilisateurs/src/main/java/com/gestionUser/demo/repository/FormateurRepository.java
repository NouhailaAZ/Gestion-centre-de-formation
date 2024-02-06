package com.gestionUser.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.gestionUser.demo.entities.formateur;
import com.gestionUser.demo.entities.participant;

public interface FormateurRepository extends CrudRepository<formateur, Integer> {
	formateur findByEmail(String email);
}
