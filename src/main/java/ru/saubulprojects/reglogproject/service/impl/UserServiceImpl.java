package ru.saubulprojects.reglogproject.service.impl;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import ru.saubulprojects.reglogproject.model.Role;
import ru.saubulprojects.reglogproject.model.User;
import ru.saubulprojects.reglogproject.repository.UserRepository;
import ru.saubulprojects.reglogproject.service.UserService;
import ru.saubulprojects.reglogproject.web.dto.UserRegistrationDTO;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepo;
	
	public UserServiceImpl(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	@Override
	public User save(UserRegistrationDTO userDTO) {
		User user = new User(userDTO.getFirstName(), 
				   	 		 userDTO.getLastName(), 
				   	 		 userDTO.getEmail(), 
				   	 		 userDTO.getPassword(),
				   	 		 Arrays.asList(new Role("ROLE_USER")));
		return userRepo.save(user);
	}
	
}
