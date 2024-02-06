package com.fst.Commantaire.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Participant {
	
	private Integer idParticipant;
	private String nom;
	private String email;
	private String pass;
}
