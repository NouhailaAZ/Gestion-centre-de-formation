package com.fsts.formation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Participant {
	
	private Integer id;
	private String nom;
	private String email;
	private String pass;
}
