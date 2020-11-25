/**
 * 
 */
package com.serviceImpl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Consultation;
import com.entities.Medecin;
import com.entities.Patient;
import com.repository.ConsultationRepository;
import com.repository.MedecinRepository;
import com.repository.PatientRepository;
import com.service.MedecinService;

/**
 * @author Tony
 *
 */
@Service
public class MedecinServiceImpl  extends DaoServiceImpl<Medecin> implements MedecinService{

	@Autowired
	MedecinRepository dao;
	@Autowired
	ConsultationRepository daoConsultation;
	/**
	 * @author Florian
	 * @param email
	 *
	 */
	@Override
	public Medecin findMedecinByEmail(String email) {
		return dao.findByEmail(email);
	}
	
	@Override
	public List<Patient> findAllPatients(Long id) {
		List<Consultation> listConsultation = daoConsultation.getConsultationsByIdMedecin(id);
		return listConsultation.stream()
				.map(x -> x.getPatient())
				.distinct()
				.collect(Collectors.toList());
	}

}
