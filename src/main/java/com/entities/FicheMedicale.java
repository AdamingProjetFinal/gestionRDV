/**
 * 
 */
package com.entities;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Tony
 *
 */

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class FicheMedicale implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_FICHE")
	private Long id;
	private ZonedDateTime date;
	private String antecedents;
	private String observations;
	
	// Association
	@ManyToOne
	@JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID_UTILISATEUR")
	private Patient patient;

	/**
	 * @return the id
	 * @author:tony
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the date
	 * @author:tony
	 */
	public ZonedDateTime getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(ZonedDateTime date) {
		this.date = date;
	}

	/**
	 * @return the antecedents
	 * @author:tony
	 */
	public String getAntecedents() {
		return antecedents;
	}

	/**
	 * @param antecedents the antecedents to set
	 */
	public void setAntecedents(String antecedents) {
		this.antecedents = antecedents;
	}

	/**
	 * @return the observations
	 * @author:tony
	 */
	public String getObservations() {
		return observations;
	}

	/**
	 * @param observations the observations to set
	 */
	public void setObservations(String observations) {
		this.observations = observations;
	}

	/**
	 * @return the patient
	 * @author:tony
	 */
	
	@JsonIgnoreProperties({"fichesMedicales"})
	public Patient getPatient() {
		return patient;
	}

	/**
	 * @param patient the patient to set
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	
}
