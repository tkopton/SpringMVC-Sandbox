package com.thomaskopton.springmvc01controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thomaskopton.springmvc01.service.ExpertService;

@Controller
@RequestMapping("annotation")
public class ExpertController {
	
	@Autowired
	private ExpertService expertService;
	
	@RequestMapping("/experts")
	public String list(Model model) {
		model.addAttribute("experts", expertService.getAllExperts());
		
		return "experts";
	}
	
	@RequestMapping("/update/experts")
	public String updateExperts(Model model) {
		expertService.updateAllExperts();
		
		return "redirect:/annotation/experts";
	}
}
