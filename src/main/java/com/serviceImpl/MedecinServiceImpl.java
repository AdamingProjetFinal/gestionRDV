/**
 * 
 */
package com.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Consultation;
import com.entities.Medecin;
import com.repository.MedecinRepository;
import com.service.MedecinService;

/**
 * @author Tony
 *
 */
@Service
public class MedecinServiceImpl  extends DaoServiceImpl<Medecin> implements MedecinService{


}
