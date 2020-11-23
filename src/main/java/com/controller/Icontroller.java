/**
 * 
 */
package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Tony
 *
 */
@RequestMapping
public interface Icontroller<O> {
	
	/**
	 * 
	 * Methode save exposee 
	 * @param obj : une entitee generique 
	 * @return Map: Map&#60String, Object&#62
	 * 
	 */
	@PostMapping
	Map<String, Object> save(@RequestBody O obj);
	
	/**
	 * 
	 * Methode update exposee 
	 * @param obj : une entitee generique 
	 * @return Map: Map&#60String, Object&#62
	 * 
	 */
	@PutMapping
	Map<String, Object> update(@RequestBody O obj);
	
	/**
	 * 
	 * Methode delete exposee 
	 * @param id : l'id de l'élément à supprimer
	 * @return Map: Map&#60String, Object&#62
	 * 
	 */
	@DeleteMapping("/{id}")
	Map<String, Object> delete(@PathVariable("id")Long id);
	
	/**
	 * 
	 * Methode find exposee 
	 * @param id : l'id de l'élément à trouver
	 * @return Map: Map&#60String, Object&#62
	 * 
	 */
	@GetMapping("/{id}")
	Map<String, Object> find(@PathVariable("id")Long id);
	
	/**
	 * 
	 * Methode findAll exposee 
	 * @return List: list d'objet 
	 * 
	 */
	@GetMapping("/all")
	List<O> findAll();
	

}
