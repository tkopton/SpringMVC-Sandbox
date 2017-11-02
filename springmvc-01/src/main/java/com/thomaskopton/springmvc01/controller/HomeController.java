package com.thomaskopton.springmvc01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping
	public String welcome(Model model, RedirectAttributes redirectAttributes) {
		model.addAttribute("greeting", ": Welcome to the Patient Annotation System.");
		model.addAttribute("tagline", ": OurPuppet decision supporting system.");
		
		redirectAttributes.addFlashAttribute("greeting", "> Welcome to the Patient Annotation System.");
		redirectAttributes.addFlashAttribute("tagline", "> OurPuppet decision supporting system.");
		
		return "redirect:/welcome/greeting";
	}
	
	@RequestMapping("/welcome/greeting")
	public String greeting() {
	   return "welcome";
	}
}
