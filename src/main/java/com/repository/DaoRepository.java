/**
 * 
 */
package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author Tony
 *
 */
@NoRepositoryBean
public interface DaoRepository<O>  extends JpaRepository<O,Long>{

}
