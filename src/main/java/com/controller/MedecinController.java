/**
 * 
 */
package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Medecin;
import com.entities.Patient;
import com.service.MedecinService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Tony
 *
 */
@RequestMapping(value = "/medecin")
@RestController
@CrossOrigin(origins = "*")
@Slf4j
public class MedecinController extends ControllerImpl<Medecin>{
	@Autowired
	MedecinService service;
	
	@GetMapping("/email/{email}")
	public Map<String, Object> findByEmail(@PathVariable("email") String email) {
		log.info("Recherche de le medecin avec l'email: " + email);
		Map<String, Object> response = new HashMap<String, Object>();
		Medecin m = service.findMedecinByEmail(email);
		log.info("Medecin trouvé : " + m.toString());
		response.put("status", HttpStatus.FOUND);
		response.put("data", m); 
		log.info("Retour de la requête : " + response.toString());
		return response;
	}
	
	@GetMapping("/patients/{id}")
	public List<Patient> findAllPatientById(@PathVariable("id") Long id) {
		return service.findAllPatients(id);
	}
}
