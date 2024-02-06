package com.fst.Commantaire.entities;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Formation {
	private long id;
	private String nom;
	private int age; 
	private String ville;
	private int role;
	
	private String Login;

	private String mot_de_passe;
	public Formation() {
		super();
		// TODO Auto-generated constructor stub
	}
}
