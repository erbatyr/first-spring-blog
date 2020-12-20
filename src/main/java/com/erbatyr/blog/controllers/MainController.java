package com.erbatyr.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/") //main page localhost:8080/
	public String home(Model model) {
		model.addAttribute("title", "Home page"); //{title} in html
		return "home";  //return home.html
	}
}