/**
 * 
 */
package com.service;

import java.util.List;

import com.entities.Act;

/**
 * @author Tony
 *
 */
public interface ActService {
	Act saveOrUpdate(Act act);
	void delete(Long id);
	Act find (Long id);
	List<Act>findAll();

}
