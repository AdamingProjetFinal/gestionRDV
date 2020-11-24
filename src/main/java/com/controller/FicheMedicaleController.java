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

import com.entities.FicheMedicale;
import com.service.FicheMedicaleService;

/**
 * @author Tony
 *
 */
@RestController
@RequestMapping("/ficheMedicale")
@CrossOrigin("*")
public class FicheMedicaleController extends ControllerImpl<FicheMedicale> {

	@Autowired
	FicheMedicaleService service;

	@GetMapping("/getByIdPatient/{id}")
	List<FicheMedicale> getByIdPatient(@PathVariable("id") Long id ){
		return service.findByIdPatient(id);
	}
}
