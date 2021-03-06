/**
 * 
 */
package com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Act;
import com.repository.ActRepository;
import com.service.ActService;

/**
 * @author Tony
 *
 */
@Service
public class ActServiceImpl implements ActService {
	@Autowired
	ActRepository dao;
	
	@Override
	public Act saveOrUpdate(Act act) {
		
		return dao.save(act);
	}

	@Override
	public void delete(Long id) {
	dao.deleteById(id);
		
	}

	@Override
	public Act find(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public List<Act> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
}
