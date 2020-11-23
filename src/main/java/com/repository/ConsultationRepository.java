/**
 * 
 */
package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entities.Consultation;

/**
 * @author Tony
 *
 */
@Repository
public interface ConsultationRepository extends DaoRepository<Consultation> {

@Query("SELECT c FROM Consultation as c WHERE medecin_id =:idMedecin")
List<Consultation> getConsultationsByIdMedecin( @Param("idMedecin") Long id);
}
