package com.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue(value = "Medecin")
public class Medecin extends Utilisateur {

	@Column(name = "N°PUBLIC")
	private String codePublic;
	
	
	// Associations
	@Embedded
	private Adresse adresse;
	
	@ManyToOne
	@JoinColumn(name = "SPECIALITE_ID", referencedColumnName = "ID_SPECIALITE")
	private Specialite specialite;
	
	//private List<Consultation> consultations;
}
