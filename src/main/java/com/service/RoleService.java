/**
 * 
 */
package com.service;

import java.util.List;

import com.entities.Role;

/**
 * @author Tony
 *
 */
public interface RoleService {
	Role saveOrUpdate(Role role);
	void delete(Long id);
	Role find (Long id);
	List<Role>findAll();
}
