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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Tony
 *
 */
@Data
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

}
