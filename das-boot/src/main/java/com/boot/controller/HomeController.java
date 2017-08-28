/**
 * 
 */
package com.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shashank
 *
 */
@RestController
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "Das Boot, Reporting for duty!";
	}

}
