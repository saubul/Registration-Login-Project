package ru.saubulprojects.reglogproject.service;

import ru.saubulprojects.reglogproject.model.User;
import ru.saubulprojects.reglogproject.web.dto.UserRegistrationDTO;

public interface UserService {
	
	public User save(UserRegistrationDTO userDTO);
	
}
