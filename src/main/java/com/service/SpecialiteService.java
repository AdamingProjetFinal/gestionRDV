/**
 * 
 */
package com.service;

import java.util.List;

import com.entities.Specialite;

/**
 * @author Tony
 *
 */
public interface SpecialiteService {
	Specialite saveOrUpdate(Specialite specialite);
	void delete(Long id);
	Specialite find (Long id);
	List<Specialite>findAll();

}
