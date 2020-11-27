/**
 * 
 */
package com.dto;

import java.time.ZonedDateTime;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Florian
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"idComptabilite","idConsultation","frais","gain","date"})
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ComptabiliteDTO {
	@JsonProperty("idComptabilite")
	private Long idComptabilite;
	
	@JsonProperty("idConsultation")
	private Long idConsultation;
	
	@JsonProperty("frais")
	private Double frais;
	
	@JsonProperty("gain")
	private Double gain;
	
	@JsonProperty("date")
	private ZonedDateTime date;

	/**
	 * @return the idComptabilite
	 */
	@JsonProperty("idComptabilite")
	public Long getIdComptabilite() {
		return idComptabilite;
	}

	/**
	 * @param idComptabilite the idComptabilite to set
	 */
	@JsonProperty("idComptabilite")
	public void setIdComptabilite(Long idComptabilite) {
		this.idComptabilite = idComptabilite;
	}

	/**
	 * @return the idConsultation
	 */
	@JsonProperty("idConsultation")
	public Long getIdConsultation() {
		return idConsultation;
	}

	/**
	 * @param idConsultation the idConsultation to set
	 */
	@JsonProperty("idConsultation")
	public void setIdConsultation(Long idConsultation) {
		this.idConsultation = idConsultation;
	}

	/**
	 * @return the frais
	 */
	@JsonProperty("frais")
	public Double getFrais() {
		return frais;
	}

	/**
	 * @param frais the frais to set
	 */
	@JsonProperty("frais")
	public void setFrais(Double frais) {
		this.frais = frais;
	}

	/**
	 * @return the gain
	 */
	@JsonProperty("gain")
	public Double getGain() {
		return gain;
	}

	/**
	 * @param gain the gain to set
	 */
	@JsonProperty("gain")
	public void setGain(Double gain) {
		this.gain = gain;
	}

	/**
	 * @return the date
	 */
	@JsonProperty("date")
	public ZonedDateTime getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	@JsonProperty("date")
	public void setDate(ZonedDateTime date) {
		this.date = date;
	}
}
