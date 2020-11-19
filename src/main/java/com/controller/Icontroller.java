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
	
	@PostMapping
	Map<String, Object> save(@RequestBody O obj);
	@PutMapping
	Map<String, Object> update(@RequestBody O obj);
	@DeleteMapping("/{id}")
	Map<String, Object> delete(@PathVariable("id")Long id);
	@GetMapping("/{id}")
	Map<String, Object> find(@PathVariable("id")Long id);
	@GetMapping("/all")
	List<O>findAll();
	

}
