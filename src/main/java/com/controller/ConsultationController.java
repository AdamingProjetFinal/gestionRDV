/**
 * 
 */
package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Consultation;
import com.entities.Medecin;
import com.entities.Patient;
import com.service.ConsultationService;
import com.service.MedecinService;
import com.service.PatientService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Tony
 *
 */
@RestController
@RequestMapping("/consultation")
@CrossOrigin(origins = "*")
@Slf4j
public class ConsultationController{
	
	@Autowired
	ConsultationService service;
	@Autowired
	 MedecinService MedecinService;

	@Autowired
	 PatientService patientService;
	@GetMapping("/getByIdMedecin/{id}")
	List<Consultation> getByIdMedecin(@PathVariable("id") Long id ){
		return service.findByIdMedecin(id);
	}
	
	@GetMapping("/getByIdPatient/{id}")
	List<Consultation> getByIdPatient(@PathVariable("id") Long id ){
		return service.findByIdPatient(id);
	}
	
	@PostMapping("/saveConsultationMedPat/{idMedecin}/{idPatient}")
	Consultation saveConsultationByIdPatientAndIdMedecin(@PathVariable("idMedecin") Long idmedecin , @PathVariable("idPatient") Long idPatient,@RequestBody Consultation consultation ){
		Patient pat = patientService.find(idPatient);
		Medecin med = MedecinService.find(idmedecin);
		consultation.setMedecin(med);
		consultation.setPatient(pat);
		System.out.println("********************************"+consultation.getDate()+"*******************************");
		return service.saveOrUpdate(consultation);
	}
		

	@PostMapping
	public Map<String, Object> save(@RequestBody Consultation cons) {
		log.info("Sauvegarde d'un objet de type : " + cons.getClass()); 
		log.info("Objet : " + cons); 
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("status", HttpStatus.OK);
		response.put("data",service.saveOrUpdate(cons));
		log.info("Retour de la requête save: " + response.toString());
		return response;
	}

	@PutMapping
	public Map<String, Object> update(@RequestBody Consultation cons) {
		log.info("Mise à jour d'un objet de type : " + cons.getClass()); 
		log.info("Objet : " + cons); 
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("status", HttpStatus.OK);
		response.put("data", service.saveOrUpdate(cons));
		log.info("Retour de la requête update : " + response.toString()); 
		return response;
	}

	

	@DeleteMapping("/{id}")
	public Map<String, Object> delete(@PathVariable("id") Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			service.delete(id);
			response.put("status", HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}

	@GetMapping("/{id}")
	public Map<String, Object> find(@PathVariable("id") Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
	
			Consultation cons = service.find(id);
			log.info("recherche");
			response.put("status", HttpStatus.FOUND);
			response.put("data", service.find(id)); 

		return response;
	}

	@GetMapping("/all")
	public List<Consultation> findAll() {
		return service.findAll();
	}

}
