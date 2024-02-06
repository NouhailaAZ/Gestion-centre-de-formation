package com.gestionUser.demo.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class participant {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
		
	@Column(nullable = false)
	private String nom;
	@Column( nullable = false)
	private String email;
	@Column( nullable = false)
	private String pass;
	private int idFormation;
}
