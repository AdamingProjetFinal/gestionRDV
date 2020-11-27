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
public class FicheMedicaleServiceImpl implements FicheMedicaleService{

	@Autowired
	FicheMedicaleRepository dao;
	
	@Override
	public List<FicheMedicale> findByIdPatient(Long id) {
		return dao.getFicheMedicaleByIdPatient(id);
	}
	
	@Override
	public FicheMedicale saveOrUpdate(FicheMedicale ficheMedicale) {
		
		return dao.save(ficheMedicale);
	}

	@Override
	public void delete(Long id) {
	dao.deleteById(id);
		
	}

	@Override
	public FicheMedicale find(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public List<FicheMedicale> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
}
