/**
 * 
 */
package com.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Consultation;

/**
 * @author Tony
 *
 */
@RestController
@RequestMapping("/consultation")
@CrossOrigin(origins = "*")
public class ConsultationController extends ControllerImpl<Consultation>{

}
