/**
 * 
 */
package com.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Medecin;
import com.repository.MedecinRepository;
import com.service.MedecinService;

/**
 * @author Tony
 *
 */
@Service
public class MedecinServiceImpl  extends DaoServiceImpl<Medecin> implements MedecinService{
	@Autowired
	MedecinRepository dao;
	/**
	 * @author Florian
	 * @param email
	 *
	 */
	@Override
	public Medecin findMedecinByEmail(String email) {
		return dao.findByEmail(email);
	}
}
