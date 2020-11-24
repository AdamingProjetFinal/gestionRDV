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
public interface ConsultationService extends DaoService<Consultation> {
	
	List<Consultation> findByIdMedecin(Long id);
	
	List<Consultation> findByIdPatient(Long id);

}
