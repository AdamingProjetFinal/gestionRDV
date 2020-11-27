/**
 * 
 */
package com.service;

import java.util.List;



import com.entities.Consultation;

/**
 * @author Tony
 *
 */
public interface ConsultationService{
	Consultation saveOrUpdate(Consultation cons);
	void delete(Long id);
	Consultation find (Long id);
	List<Consultation>findAll();
	List<Consultation> findByIdMedecin(Long id);
	
	List<Consultation> findByIdPatient(Long id);

}
