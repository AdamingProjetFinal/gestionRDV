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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ROLE")
	private Long id;
	@Column(name = "ROLE")
	private String role;
	@Column(name = "DESCRIPTION")
	private String description;
	
	@ManyToMany
	@JoinTable(name = "Role_Utilisateur", 
		joinColumns = @JoinColumn(name = "ROLE_ID"),
		inverseJoinColumns = @JoinColumn(name = "UTILISATEUR_ID"))
	@JsonIgnore
	List<Utilisateur> utilisateurs;
	
	
}
