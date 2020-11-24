/**
 * 
 */
package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entities.FicheMedicale;

/**
 * @author Tony
 *
 */
@Repository
public interface FicheMedicaleRepository extends DaoRepository<FicheMedicale> {

	@Query("SELECT f FROM FicheMedicale as f WHERE patient_id =:idPatient")
	List<FicheMedicale> getFicheMedicaleByIdPatient(@Param("idPatient") Long id);
}
