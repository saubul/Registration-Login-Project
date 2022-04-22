package ru.saubulprojects.reglogproject.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import ru.saubulprojects.reglogproject.dto.UserRegistrationDTO;
import ru.saubulprojects.reglogproject.model.User;

public interface UserService extends UserDetailsService{
	
	public User save(UserRegistrationDTO userDTO);
	
	public boolean existsByEmail(String email);
	
}
