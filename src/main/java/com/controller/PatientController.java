/**
 * 
 */
package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Patient;
import com.service.PatientService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Tony
 *
 */
@RestController
@RequestMapping(value ="/patient")
@CrossOrigin(origins = "*")
@Slf4j
public class PatientController extends ControllerImpl<Patient> {
	
	@Autowired
	PatientService service;
	
	@GetMapping("/email/{email}")
	public Map<String, Object> findByEmail(@PathVariable("email") String email) {
		log.info("Recherche de l'objet avec l'id : " + email);
		Map<String, Object> response = new HashMap<String, Object>();
		Patient p = service.findPatientByEmail(email);
		log.info("Objet trouvé : " + p.toString());
		response.put("status", HttpStatus.FOUND);
		response.put("data", p); 
		log.info("Retour de la requête : " + response.toString());
		return response;
	}

}
