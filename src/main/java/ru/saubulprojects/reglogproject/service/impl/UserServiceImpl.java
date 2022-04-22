package ru.saubulprojects.reglogproject.service.impl;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ru.saubulprojects.reglogproject.model.Role;
import ru.saubulprojects.reglogproject.model.User;
import ru.saubulprojects.reglogproject.repository.UserRepository;
import ru.saubulprojects.reglogproject.service.UserService;
import ru.saubulprojects.reglogproject.web.dto.UserRegistrationDTO;

@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepo;
	
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
	
	@Override
	public boolean existsByEmail(String email) {
		Optional<User> user = Optional.ofNullable(userRepo.findByEmail(email));
		return user.isPresent();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
	}
	
}
