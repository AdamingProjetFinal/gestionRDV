/**
 * 
 */
package com.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Specialite;

/**
 * @author Tony
 *
 */
@RestController
@RequestMapping("/specialite")
@CrossOrigin(origins = "*")
public class SpecialiteController extends ControllerImpl<Specialite> {

}
