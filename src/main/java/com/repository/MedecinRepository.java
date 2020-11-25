/**
 * 
 */
package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entities.FicheMedicale;
import com.entities.Medecin;

/**
 * @author Tony
 *
 */
@Repository
public interface MedecinRepository extends DaoRepository<Medecin>{
	/**
	 * @author Florian
	 * @param email	
	 *
	 */
	public Medecin findByEmail(String email);
	
}
