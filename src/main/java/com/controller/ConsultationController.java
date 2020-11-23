/**
 * 
 */
package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Consultation;
import com.service.ConsultationService;

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

	@GetMapping("/getByIdMedecin/{id}")
	List<Consultation> getByIdMedecin(@PathVariable("id") Long id ){
		return service.findByIdMedecin(id);
	}

}
