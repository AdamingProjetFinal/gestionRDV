/**
 * 
 */
package com.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.FicheMedicale;

/**
 * @author Tony
 *
 */
@RestController
@RequestMapping("/ficheMedicale")
@CrossOrigin("*")
public class FicheMedicaleController extends ControllerImpl<FicheMedicale> {

}
