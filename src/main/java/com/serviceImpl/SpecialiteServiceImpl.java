/**
 * 
 */
package com.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Specialite;
import com.repository.DaoRepository;
import com.repository.SpecialiteRepository;
import com.service.SpecialiteService;

/**
 * @author Tony
 *
 */
@Service
public class SpecialiteServiceImpl implements SpecialiteService {

	@Autowired
	SpecialiteRepository dao;
	
	@Override
	public Specialite saveOrUpdate(Specialite specialite) {
		
		return dao.save(specialite);
	}

	@Override
	public void delete(Long id) {
	dao.deleteById(id);
		
	}

	@Override
	public Specialite find(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public List<Specialite> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
}
