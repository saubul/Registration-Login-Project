package ru.saubulprojects.reglogproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserLoginController {

	@GetMapping("/login")
	public String login() {
		return "login/loginForm";
	}
	
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
}
