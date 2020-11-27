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

import com.entities.FicheMedicale;
import com.service.ActService;
import com.service.FicheMedicaleService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Tony
 *
 */
@RestController
@RequestMapping("/ficheMedicale")
@CrossOrigin("*")
@Slf4j
public class FicheMedicaleController {

	@Autowired
	FicheMedicaleService service;

	@GetMapping("/getByIdPatient/{id}")
	List<FicheMedicale> getByIdPatient(@PathVariable("id") Long id ){
		return service.findByIdPatient(id);
	}
	
	@PostMapping
	public Map<String, Object> save(@RequestBody FicheMedicale ficheMedicale) {
		log.info("Sauvegarde d'un objet de type : " + ficheMedicale.getClass()); 
		log.info("Objet : " + ficheMedicale); 
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("status", HttpStatus.OK);
		response.put("data",service.saveOrUpdate(ficheMedicale));
		log.info("Retour de la requête save: " + response.toString());
		return response;
	}

	@PutMapping
	public Map<String, Object> update(@RequestBody FicheMedicale ficheMedicale) {
		log.info("Mise à jour d'un objet de type : " + ficheMedicale.getClass()); 
		log.info("Objet : " + ficheMedicale); 
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("status", HttpStatus.OK);
		response.put("data", service.saveOrUpdate(ficheMedicale));
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
	public List<FicheMedicale> findAll() {
		return service.findAll();
	}
}
