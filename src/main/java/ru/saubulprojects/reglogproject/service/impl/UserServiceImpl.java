package ru.saubulprojects.reglogproject.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ru.saubulprojects.reglogproject.dto.UserRegistrationDTO;
import ru.saubulprojects.reglogproject.model.Role;
import ru.saubulprojects.reglogproject.model.User;
import ru.saubulprojects.reglogproject.repository.UserRepository;
import ru.saubulprojects.reglogproject.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepo;
	private final BCryptPasswordEncoder passEncoder;
	
	public UserServiceImpl(UserRepository userRepo, BCryptPasswordEncoder passEncoder) {
		this.userRepo = userRepo;
		this.passEncoder = passEncoder;
	}
	
	@Override
	public User save(UserRegistrationDTO userDTO) {
		User user = new User(userDTO.getFirstName(), 
				   	 		 userDTO.getLastName(), 
				   	 		 userDTO.getEmail(), 
				   	 		 passEncoder.encode(userDTO.getPassword()),
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
		
		User user = userRepo.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		
	}
	
}
