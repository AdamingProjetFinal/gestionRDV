package com.toto;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

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
	private Specialite specialite;
	//private List<Consultation> consultations;
	
	@Embedded
	private Adresse adresse;
}
