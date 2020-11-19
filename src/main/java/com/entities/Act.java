package com.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Act {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ACT")
	private Long id;
	@Column(name = "NOM")
	private String nom;
	@Column(name = "PRIX")
	private float prix;
	
	// Association
	@ManyToMany
	@JoinTable(name = "ACT_CONSULTATION", 
		joinColumns = @JoinColumn(name = "ACT_ID"),
		inverseJoinColumns = @JoinColumn(name = "CONSULTATION_ID"))
	List<Consultation> consultations;
}
