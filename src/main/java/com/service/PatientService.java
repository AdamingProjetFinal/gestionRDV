/**
 * 
 */
package com.service;

import com.entities.Patient;

/**
 * @author Tony
 *
 */
public interface PatientService extends DaoService<Patient> {
	public Patient findPatientByEmail(String email);

}
