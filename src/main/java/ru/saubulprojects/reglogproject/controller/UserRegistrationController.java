package ru.saubulprojects.reglogproject.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	private final UserService userService;
	
	public UserRegistrationController(UserService userService) {
		this.userService = userService;
	}
	
	@ModelAttribute("user")
	public UserRegistrationDTO userRegistrationDTO() {
		return new UserRegistrationDTO();
	}
	
	@ModelAttribute("userExist")
	public boolean userExist() {
		return false;
	}
	
	
	@GetMapping()
	public String showRegistrationForm() {
		return "registration/registerForm";
	}
	
	@PostMapping()
	public String registerUserAccount(@Valid @ModelAttribute("user") UserRegistrationDTO userDTO, Errors errors, Model model) {
		if(errors.hasErrors()) {
			return "registration/registerForm";
		}
		if(userService.existsByEmail(userDTO.getEmail())) {
			model.addAttribute("userExist", true);
			return "registration/registerForm";
		}
		userService.save(userDTO);
		return "redirect:/registration?success";
	}
}
