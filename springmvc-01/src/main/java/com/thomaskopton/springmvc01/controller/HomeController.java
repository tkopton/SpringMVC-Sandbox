package com.thomaskopton.springmvc01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	/**
	 * @param model - view model
	 * @return - returns the file name of the web page to be displayed
	 */
	@RequestMapping("/welcome")
	public String welcome(Model model) {
		model.addAttribute("greeting", ": Welcome to the Patient Annotation System.");
		model.addAttribute("tagline", ": OurPuppet decision supporting system.");
		
		return "welcome";
	}
}
