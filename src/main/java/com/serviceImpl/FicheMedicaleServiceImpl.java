/**
 * 
 */
package com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.FicheMedicale;
import com.repository.FicheMedicaleRepository;
import com.service.FicheMedicaleService;

/**
 * @author Tony
 *
 */
@Service
public class FicheMedicaleServiceImpl extends DaoServiceImpl<FicheMedicale> implements FicheMedicaleService{

	@Autowired
	FicheMedicaleRepository dao;
	
	@Override
	public List<FicheMedicale> findByIdPatient(Long id) {
		return dao.getFicheMedicaleByIdPatient(id);
	}

}
