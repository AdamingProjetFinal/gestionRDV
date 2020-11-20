/**
 * 
 */
package com.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Patient;

/**
 * @author Tony
 *
 */
@RestController
@RequestMapping(value ="/patient")
@CrossOrigin(origins = "*")
public class PatientController extends ControllerImpl<Patient> {

}
