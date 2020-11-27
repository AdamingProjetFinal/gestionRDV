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

import com.entities.Act;
import com.entities.Medecin;
import com.entities.Patient;
import com.service.ActService;
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
public class MedecinController {
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
	
	@PostMapping
	public Map<String, Object> save(@RequestBody Medecin medecin) {
		log.info("Sauvegarde d'un objet de type : " + medecin.getClass()); 
		log.info("Objet : " + medecin); 
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("status", HttpStatus.OK);
		response.put("data",service.saveOrUpdate(medecin));
		log.info("Retour de la requête save: " + response.toString());
		return response;
	}

	@PutMapping
	public Map<String, Object> update(@RequestBody Medecin medecin) {
		log.info("Mise à jour d'un objet de type : " + medecin.getClass()); 
		log.info("Objet : " + medecin); 
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("status", HttpStatus.OK);
		response.put("data", service.saveOrUpdate(medecin));
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
	
			log.info("recherche");
			response.put("status", HttpStatus.FOUND);
			response.put("data", service.find(id)); 

		return response;
	}
	@GetMapping("/all")
	public List<Medecin> findAll() {
		return service.findAll();
	}
}
