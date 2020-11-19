/**
 * 
 */
package com.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Medecin;

/**
 * @author Tony
 *
 */
@RequestMapping(value = "/medecin")
@RestController
@CrossOrigin(origins = "*")
public class MedecinController extends ControllerImpl<Medecin>{

}
