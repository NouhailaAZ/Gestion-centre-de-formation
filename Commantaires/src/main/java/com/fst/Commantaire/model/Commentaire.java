package com.fst.Commantaire.model;

import java.sql.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fst.Commantaire.entities.Formation;
import com.fst.Commantaire.entities.Participant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Commentaire {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//pour id
	@Column
	private int id;
	@Column
	private String description;
	@Column
	private int idFormation;
	@Transient
	@JsonIgnore
	private Formation formation;
	@Column
	private int idParticipant;
	@Transient
	@JsonIgnore
	private Participant participant;
	
	
}
