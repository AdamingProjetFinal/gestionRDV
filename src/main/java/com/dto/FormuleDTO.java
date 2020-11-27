package com.dto;

import java.time.ZonedDateTime;

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
@JsonPropertyOrder({"id","nomProduit","prix"})
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FormuleDTO {
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("date")
	private ZonedDateTime date;
	
	@JsonProperty("taxe")
	private double taxe;

	/**
	 * @return the id
	 */
	@JsonProperty("id")
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	@JsonProperty("id")
	public void setId(Long id) {
		this.id = id;
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

	/**
	 * @return the taxe
	 */
	@JsonProperty("taxe")
	public double getTaxe() {
		return taxe;
	}

	/**
	 * @param taxe the taxe to set
	 */
	@JsonProperty("taxe")
	public void setTaxe(double taxe) {
		this.taxe = taxe;
	}
	


}
