/**
 * 
 */
package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.entities.Patient;

/**
 * @author Tony
 *
 */
@RequestMapping(value ="/patient")

public class PatientController extends ControllerImpl<Patient> {

}
