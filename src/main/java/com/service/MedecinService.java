/**
 * 
 */
package com.service;

import java.util.List;

import com.entities.Consultation;
import com.entities.Medecin;
import com.entities.Patient;

/**
 * @author Tony
 *
 */
public interface MedecinService {

	public Medecin findMedecinByEmail(String email);
	
	public List<Patient> findAllPatients(Long id);
	Medecin saveOrUpdate(Medecin medecin);
	void delete(Long id);
	Medecin find (Long id);
	List<Medecin>findAll();

}
