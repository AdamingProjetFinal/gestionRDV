/**
 * 
 */
package com.entities;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Consultation implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CONSULTATION")
	private Long id;
	private ZonedDateTime date;
	private String note;
	private boolean deplacement;
	private boolean validationMedecin;
	private int dureeConsultation;
	@Column(name = "PRIX_TTC")
	private double prixTTC;
	
	
	// Association
	@ManyToOne
	@JoinColumn(name = "MEDECIN_ID", referencedColumnName = "ID_UTILISATEUR")
	private Medecin medecin;
	
	
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
	 * @return the note
	 * @author:tony
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * @return the deplacement
	 * @author:tony
	 */
	public boolean isDeplacement() {
		return deplacement;
	}

	/**
	 * @param deplacement the deplacement to set
	 */
	public void setDeplacement(boolean deplacement) {
		this.deplacement = deplacement;
	}

	/**
	 * @return the validationMedecin
	 * @author:tony
	 */
	public boolean isValidationMedecin() {
		return validationMedecin;
	}

	/**
	 * @param validationMedecin the validationMedecin to set
	 */
	public void setValidationMedecin(boolean validationMedecin) {
		this.validationMedecin = validationMedecin;
	}

	/**
	 * @return the medecin
	 * @author:tony
	 */
	@JsonIgnoreProperties({"consultations"})
	public Medecin getMedecin() {
		return medecin;
	}

	/**
	 * @param medecin the medecin to set
	 */
	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	/**
	 * @return the patient
	 * @author:tony
	 */
	@JsonIgnoreProperties({"consultations"})
	public Patient getPatient() {
		return patient;
	}

	/**
	 * @param patient the patient to set
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 * @return the dureeConsultation
	 * @author:tony
	 */
	public int getDureeConsultation() {
		return dureeConsultation;
	}

	/**
	 * @param dureeConsultation the dureeConsultation to set
	 */
	public void setDureeConsultation(int dureeConsultation) {
		this.dureeConsultation = dureeConsultation;
	}
	
	
	
	
}
