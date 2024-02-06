package com.fsts.formation.entities;

import java.util.Date;

import com.fsts.formation.model.Formateur;
import com.fsts.formation.model.Participant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "formation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Formation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFormation;
	@Column(name = "Titre_formation")
	private String TitreFormation;
	@Column(name = "description")
	private String description;
	@Column(name = "date_debut")
	private Date dateDebut;
	@Column(name = "date_fin")
	private Date dateFin;
	@Column(name = "statut")//programmée , en cours , terminée ...
	private String statut;
	@Column(name = "montant_paye_formateur")
	private long montantPayeFormateur;
	@Column(name = "montant_formation")
	private long montantFormation;
	private int idFormateur;
	@Transient
	private Formateur formateur;
}
