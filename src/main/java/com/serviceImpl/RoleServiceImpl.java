/**
 * 
 */
package com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Role;
import com.repository.RoleRepository;
import com.service.RoleService;

/**
 * @author Tony
 *
 */
@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	RoleRepository dao;
	
	@Override
	public Role saveOrUpdate(Role role) {
		
		return dao.save(role);
	}

	@Override
	public void delete(Long id) {
	dao.deleteById(id);
		
	}

	@Override
	public Role find(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
}
