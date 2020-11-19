package com.toto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Adresse {

	@Column(name = "NUMERO")
	private int numero;
	@Column(name = "RUE")
	private String rue;
	@Column(name = "CP")
	private String cp;
	@Column(name = "VILLE")
	private String ville;
	@Column(name = "COMPLEMENT")
	private String complement;
}
