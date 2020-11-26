/**
 * 
 */
package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Consultation;
import com.entities.Medecin;
import com.entities.Patient;
import com.service.ConsultationService;
import com.service.MedecinService;
import com.service.PatientService;

/**
 * @author Tony
 *
 */
@RestController
@RequestMapping("/consultation")
@CrossOrigin(origins = "*")
public class ConsultationController extends ControllerImpl<Consultation>{
	
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

}
