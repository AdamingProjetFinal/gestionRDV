/**
 * 
 */
package com.serviceImpl;

import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consommateur.AdminConsommateur;
import com.dto.ComptabiliteDTO;
import com.dto.FormuleDTO;
import com.entities.Consultation;
import com.repository.ConsultationRepository;
import com.service.ConsultationService;

/**
 * @author Tony
 *
 */
@Service
public class ConsultationServiceImpl implements ConsultationService {

	@Autowired
	ConsultationRepository dao;
	
	@Autowired
	AdminConsommateur admminConsommateur;

	@Override
	public List<Consultation> findByIdMedecin(Long id) {
		return dao.getConsultationsByIdMedecin(id);
	}

	@Override
	public List<Consultation> findByIdPatient(Long id) {
		return dao.getConsultationsByIdPatient(id);
	}
	
	@Override
	public Consultation saveOrUpdate(Consultation cons) {
		Double taxe =  admminConsommateur.getFormules().stream().sorted(Comparator.comparing(FormuleDTO::getId).reversed()).findFirst().get().getTaxe(); // Récupération de la dernière taxe
		if (cons.getId() != null) { // Vérification si c'est une mise à jour de la consultation ou ... 
			if (Boolean.compare( find( cons.getId() ).isValidationMedecin() , cons.isValidationMedecin() ) < 0) { // false true => -1 , true false => 1 , true true / false false => 0
				ComptabiliteDTO compta = new ComptabiliteDTO(null, cons.getId(), (cons.getPrixTTC() * taxe /100) / (1 + taxe / 100) , (cons.getPrixTTC() * taxe/100) / (1 + taxe/100), ZonedDateTime.now());
				admminConsommateur.payeConsultation(compta);
			}; 
			
		} else { 					// ... ou si c'est une création
			Double prixConsu = cons.getMedecin().getPrixConsultation();
			cons.setPrixTTC( prixConsu * (1 + taxe/100) );	// Application de la dernière taxe au prix de la consultation
		}
		return dao.save(cons);
	}

	@Override
	public void delete(Long id) {
	dao.deleteById(id);
		
	}

	@Override
	public Consultation find(Long id) {
		return dao.findById(id).get();
	}

	@Override
	public List<Consultation> findAll() {
		return dao.findAll();
	}

}
