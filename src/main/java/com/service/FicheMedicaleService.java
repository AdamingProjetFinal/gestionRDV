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
public interface FicheMedicaleService extends DaoService<FicheMedicale>{

	List<FicheMedicale> findByIdPatient(Long id);
}
