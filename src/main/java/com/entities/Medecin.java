package com.entities;

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
@DiscriminatorValue(value = "MED")
@ToString(callSuper=true)
public class Medecin extends Utilisateur {

	@Column(name = "N°PUBLIC")
	private String codePublic;
	
	// Associations
	@Embedded
	private Adresse adresse;
	
	@ManyToOne
	@JoinColumn(name = "SPECIALITE_ID", referencedColumnName = "ID_SPECIALITE")
	private Specialite specialite;
	
	@OneToMany(mappedBy = "medecin", cascade = CascadeType.REMOVE)
	private List<Consultation> consultations;
	
	@JsonIgnore
	@OneToMany(mappedBy = "medecin", cascade = CascadeType.REMOVE)
	private List<Patient> patients;
}
