/**
 * 
 */
package com.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Role;

/**
 * @author Tony
 *
 */
@RestController
@RequestMapping("/role")
@CrossOrigin(origins = "*")
public class RoleController extends ControllerImpl<Role>{

}
