package com.fsts.formation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Formateur {
	
	    private Integer id;
	    private String nom;
	    private String prennom;
	    private int age;
	    private String email;
	    private String password;
	    private String specialité;
	    private double salaire;
	    private String telephone;
}