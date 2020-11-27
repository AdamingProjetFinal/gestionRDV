/**
 * 
 */
package com.service;

import java.util.List;

import com.entities.Patient;

/**
 * @author Tony
 *
 */
public interface PatientService{
	public Patient findPatientByEmail(String email);
	Patient saveOrUpdate(Patient obj);
	void delete(Long id);
	Patient find (Long id);
	List<Patient>findAll();

}
