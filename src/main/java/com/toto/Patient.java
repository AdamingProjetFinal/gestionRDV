package com.toto;

import java.io.Serializable;

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
@DiscriminatorValue(value = "Patient")
public class Patient extends Utilisateur {

	// Attributs
	@Column(name = "NUMERO_SECU")
	private Long numeroSecu;
	
	// Associations 
	@Embedded
	private Adresse adresse;
	
	@ManyToOne
	@JoinColumn(name = "MEDECIN_ID", referencedColumnName = "ID_MEDECIN")
	private Medecin medecinTraitant;
	
	// private List<FicheMedicale> fichesMedicales;
	// private List<Consultation> consultations;
}
