package com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.repository.DaoRepository;
import com.service.DaoService;

public class DaoServiceImpl<O> implements DaoService<O> {

	@Autowired
	DaoRepository<O> dao;
	
	@Override
	public O saveOrUpdate(O obj) {
		
		return dao.save(obj);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public O find(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public List<O> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
