package com.toto;

import java.io.Serializable;

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
@DiscriminatorValue(value = "Patient")
public class Patient extends Utilisateur {

	@Column(name = "NUMERO_SECU")
	private Long numeroSecu;
	
	private Medecin medecinTraitant;
	// private List<FicheMedicale> fichesMedicales;
	// private List<Consultation> consultations;
	
	@Embedded
	private Adresse adresse;
}
