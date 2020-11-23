/**
 * 
 */
package com.service;

import com.entities.Medecin;

/**
 * @author Tony
 *
 */
public interface MedecinService extends DaoService<Medecin> {
	public Medecin findMedecinByEmail(String email);
}
