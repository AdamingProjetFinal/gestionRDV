/**
 * 
 */
package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
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
		log.info("Sauvegarde d'un objet de type : " + o.getClass());
		log.info("Objet : " + o);
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("status", HttpStatus.OK);
		response.put("data",service.saveOrUpdate(o));
		log.info("Retour de la requête save: " + response.toString());
		
		return response;
	}

	@Override
	public Map<String, Object> update(O o) {
		log.info("Mise à jour d'un objet de type : " + o.getClass());
		log.info("Objet : " + o);
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("status", HttpStatus.OK);
		response.put("data", service.saveOrUpdate(o));
		log.info("Retour de la requête update : " + response.toString());
		return response;
	}

	

	@Override
	public Map<String, Object> delete(Long id) {
		log.info("Suppression de l'objet avec l'id : " + id);
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			service.delete(id);
			response.put("status", HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
			response.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info("Retour de la requête delete : " + response.toString());
		return response;
	}

	@Override
	public Map<String, Object> find(Long id) {
		log.info("Recherche de l'objet avec l'id : " + id);
		Map<String, Object> response = new HashMap<String, Object>();
		O obj = service.find(id);
		log.info("Objet trouvé : " + obj.toString());
		response.put("status", HttpStatus.FOUND);
		response.put("data", obj); 
		log.info("Retour de la requête : " + response.toString());
		return response;
	}

	@Override
	public List<O> findAll() {
		log.info("Recherche de la liste d'objets : ");
		List<O> list = service.findAll();
		log.info("Retour de la requête : " + list.toString());
		return list;
	}

}
