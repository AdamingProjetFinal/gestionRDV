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

import com.service.DaoService;

import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Tony
 *
 */
@Slf4j
public class ControllerImpl<O> implements Icontroller<O>{
	@Autowired
	DaoService<O> service;
	

	@Override
	public Map<String, Object> save(O o) {
		// TODO Auto-generated method stub
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("status", HttpStatus.OK);
		response.put("data",service.saveOrUpdate(o));
		log.info("Retour de la requête save: " + response.toString());
		return response;
	}

	@Override
	public Map<String, Object> update(O o) {
		Map<String, Object> response = new HashMap<String, Object>();
		
		response.put("status", HttpStatus.OK);
		response.put("data", service.saveOrUpdate(o));
		return response;
	}

	

	@Override
	public Map<String, Object> delete(Long id) {
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

	@Override
	public Map<String, Object> find(Long id) {
		Map<String, Object> response = new HashMap<String, Object>();
	
			O obj = service.find(id);
			log.info("recherche");
			response.put("status", HttpStatus.FOUND);
			response.put("data", service.find(id)); 

		return response;
	}

	@Override
	public List<O> findAll() {
		return service.findAll();
	}

}
