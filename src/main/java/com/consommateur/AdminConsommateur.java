/**
 * 
 */
package com.consommateur;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dto.ComptabiliteDTO;
import com.dto.FormuleDTO;

/**
 * @author Florian
 *
 */
@FeignClient(name = "gestion-admin-microservice")
@RibbonClient(name = "gestion-admin-microservice")
public interface AdminConsommateur {
	
	@GetMapping(value = "/Formule/all")
	public List<FormuleDTO> getFormules();
	
	@PostMapping(value = "/Comptabilite")
	public void payeConsultation(ComptabiliteDTO compta);
}
