package com.entities;

import java.sql.Date;
import java.util.Arrays;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Damy
 *
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue(value = "MED")
public class Medecin extends Utilisateur {

	@Column(name = "N°PUBLIC")
	private String codePublic;
	
	// Associations
	@Embedded
	private Adresse adresse;
	
	@ManyToOne
	@JoinColumn(name = "SPECIALITE_ID", referencedColumnName = "ID_SPECIALITE")
	private Specialite specialite;
	
	@JsonIgnore
	@OneToMany(mappedBy = "medecin", cascade = CascadeType.REMOVE)
	private List<Consultation> consultations;
	
	@JsonIgnore
	@OneToMany(mappedBy = "medecin", cascade = CascadeType.REMOVE)
	private List<Patient> patients;

	@Override
	public String toString() {
		return "Medecin [codePublic=" + codePublic + ", adresse=" + adresse + ", specialite=" + specialite + ", id="
				+ id + ", username=" + username + ", password=" + password + ", actived=" + actived + ", nom=" + nom
				+ ", prenom=" + prenom + ", email=" + email + ", photo=" + Arrays.toString(photo) + ", dateNaissance="
				+ dateNaissance + ", telephone=" + telephone + "]";
	}
	
	
}
