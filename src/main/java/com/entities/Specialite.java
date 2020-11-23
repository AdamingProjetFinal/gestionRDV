package com.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Damy
 *
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Specialite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SPECIALITE")
	private Long idSpecialite;
	@Column(name = "NOM")
	private String nom;
	
	// Associations
	@JsonIgnore
	@OneToMany(mappedBy = "specialite", cascade = CascadeType.REMOVE)
	List<Medecin> medecins;

	@Override
	public String toString() {
		return "Specialite [idSpecialite=" + idSpecialite + ", nom=" + nom + "]";
	}
	
}
