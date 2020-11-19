/**
 * 
 */
package com.serviceImpl;

import org.springframework.stereotype.Service;

import com.entities.Patient;
import com.service.PatientService;

/**
 * @author Tony
 *
 */
@Service
public class PatientServiceImpl extends DaoServiceImpl<Patient> implements PatientService {

}
