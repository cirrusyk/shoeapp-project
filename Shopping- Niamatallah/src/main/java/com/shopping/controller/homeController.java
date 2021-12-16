package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.service.impl.UserSecurityService;

@Controller 
public class homeController {
	@Autowired
	private UserSecurityService userSecurityService;
	
		@RequestMapping("/")
public String index() {
	return "index";
	}
		
		
		@RequestMapping("/login")
		public String login (Model model) {
			model.addAttribute("classActivelogin", true);
			return "myAccount";
		}
		
		@RequestMapping ("/newUser")
		public String newUser(Model model) {
			
			
			
			model.addAttribute("classActivelogin", true);
			
			return "myAccount";
			
			
		}
		
}
