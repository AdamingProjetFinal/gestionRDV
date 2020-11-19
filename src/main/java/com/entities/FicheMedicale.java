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
	@Column(name = "ID_F")
	private Long id;
	private ZonedDateTime date;
	private String antecedents;
	private String observations;
	// relation avec patient;

}
