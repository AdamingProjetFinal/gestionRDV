package com.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Damy
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue(value = "PAT")
@ToString(callSuper=true)
public class Patient extends Utilisateur {

	// Attributs
	@Column(name = "NUMERO_SECU")
	private String numeroSecu;
	
	// Associations 
	@Embedded
	private Adresse adresse;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "MEDECIN_ID", referencedColumnName = "ID_UTILISATEUR")
	private Medecin medecin;
	
	@OneToMany(mappedBy = "patient", cascade = CascadeType.REMOVE)
	private List<FicheMedicale> fichesMedicales;
	
	@OneToMany(mappedBy = "patient", cascade = CascadeType.REMOVE)
	private List<Consultation> consultations;
}
