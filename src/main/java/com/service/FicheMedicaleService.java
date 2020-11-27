/**
 * 
 */
package com.service;

import java.util.List;

import com.entities.FicheMedicale;

/**
 * @author Tony
 *
 */
public interface FicheMedicaleService {

	List<FicheMedicale> findByIdPatient(Long id);
	FicheMedicale saveOrUpdate(FicheMedicale ficheMedicale);
	void delete(Long id);
	FicheMedicale find (Long id);
	List<FicheMedicale>findAll();
}
