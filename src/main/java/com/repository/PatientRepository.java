/**
 * 
 */
package com.repository;

import org.springframework.stereotype.Repository;

import com.entities.Patient;

/**
 * @author Tony
 *
 */
@Repository
public interface PatientRepository extends DaoRepository<Patient> {
	/**
	 * @author Tony
	 * @param email	
	 *
	 */
	public Patient findByEmail(String email);
}
