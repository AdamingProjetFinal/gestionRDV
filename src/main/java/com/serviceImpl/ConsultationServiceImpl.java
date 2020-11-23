/**
 * 
 */
package com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Consultation;
import com.repository.ConsultationRepository;
import com.service.ConsultationService;

/**
 * @author Tony
 *
 */
@Service
public class ConsultationServiceImpl extends DaoServiceImpl<Consultation> implements ConsultationService {

	@Autowired
	ConsultationRepository dao;

	@Override
	public List<Consultation> findByIdMedecin(Long id) {
	
		return dao.getConsultationsByIdMedecin(id);
	}

}
