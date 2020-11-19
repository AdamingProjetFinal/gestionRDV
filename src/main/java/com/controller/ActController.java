/**
 * 
 */
package com.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Act;

/**
 * @author Tony
 *
 */
@RestController
@RequestMapping("/act")
@CrossOrigin("*")
public class ActController extends ControllerImpl<Act>  {

}
