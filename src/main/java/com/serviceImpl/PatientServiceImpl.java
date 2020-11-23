/**
 * 
 */
package com.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Patient;
import com.repository.PatientRepository;
import com.service.PatientService;

/**
 * @author Tony
 *
 */
@Service
public class PatientServiceImpl extends DaoServiceImpl<Patient> implements PatientService {

	@Autowired
	PatientRepository dao;
	/**
	 * @author Florian
	 * @param email
	 *
	 */
	@Override
	public Patient findPatientByEmail(String email) {
		return dao.findByEmail(email);
	}

}
