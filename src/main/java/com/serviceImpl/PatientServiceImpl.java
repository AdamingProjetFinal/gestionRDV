/**
 * 
 */
package com.serviceImpl;

import java.util.List;

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
public class PatientServiceImpl implements PatientService {

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

	@Override
	public Patient saveOrUpdate(Patient patient) {
		
		return dao.save(patient);
	}

	@Override
	public void delete(Long id) {
	dao.deleteById(id);
		
	}

	@Override
	public Patient find(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public List<Patient> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
}
