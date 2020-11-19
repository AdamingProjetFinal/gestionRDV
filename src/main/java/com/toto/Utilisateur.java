package com.toto;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "utilisateurs")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type")
public class Utilisateur implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USER")
	protected Long id;
	@Column(name = "USERNAME")
	protected String username;
	@Column(name = "PASSWORD")
	protected String password;
	@Column(name = "ACTIVED")
	protected boolean actived;
	@Column(name = "NOM")
	protected String nom;
	@Column(name = "PRENOM")
	protected String prenom;
	@Column(name = "EMAIL")
	protected String email;
	@Column(name = "PHOTO")
	protected Byte[] photo;
	@Column(name = "DATE_NAISSANCE")
	protected Date dateNaissance;
	@Column(name = "TELEPHONE")
	protected String telephone;
}
