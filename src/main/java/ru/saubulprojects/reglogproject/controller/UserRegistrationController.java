package ru.saubulprojects.reglogproject.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.saubulprojects.reglogproject.service.UserService;
import ru.saubulprojects.reglogproject.web.dto.UserRegistrationDTO;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	
	private UserService userService;
	
	public UserRegistrationController(UserService userService) {
		this.userService = userService;
	}
	
	@ModelAttribute("user")
	public UserRegistrationDTO userRegistrationDTO() {
		return new UserRegistrationDTO();
	}
	
	
	@GetMapping()
	public String showRegistrationForm() {
		return "registration/register";
	}
	
	@PostMapping()
	public String registerUserAccount(@Valid @ModelAttribute("user") UserRegistrationDTO userDTO, Errors errors) {
		if(errors.hasErrors()) {
			return "registration/register";
		}
		userService.save(userDTO);
		return "redirect:/registration?success";
	}
}
