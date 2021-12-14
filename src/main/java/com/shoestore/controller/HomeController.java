package com.shoestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/newReleases")
	public String newReleases() {
		return "newReleases";
	}
	
	@RequestMapping("/man")
	public String man() {
		return "man";
	}
	
	@RequestMapping("woman")
	public String woman() {
		return "woman";
	}
	
	@RequestMapping("/about")
	public String about() {
		return "about";
	}
	
	@RequestMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	@RequestMapping("/profile")
	public String profile() {
		return "profile";
	}
	
	@RequestMapping("/trackOrders")
	public String trackOrders() {
		return "trackOrders";
	}
	@RequestMapping("/loginRegister")
	public String loginRegister() {
		return "loginRegister";
	}
	
	@RequestMapping("/cart")
	public String cart() {
		return "cart";
	}
	
	@RequestMapping("/productPage")
	public String productPage() {
		return "productPage";
	}
	
	
	
	
}
