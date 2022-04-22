package ru.saubulprojects.reglogproject.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDTO {
	
	@NotBlank(message = "First name is required")
	@Size(min = 2, message = "Length of first name must be at least 2 symbols")
	@Pattern(regexp = "[a-zA-Z]{1,}", message = "No numbers allowed in first name")
	private String firstName;
	
	@NotBlank(message = "Last name is required")
	@Size(min = 2, message = "Length of last name must be at least 2 symbols")
	@Pattern(regexp = "[a-zA-Z]{1,}", message = "No numbers allowed in last name")
	private String lastName;
	
	@Email(message = "Wrong email")
	private String email;
	
	@NotBlank(message = "Password is required")
	private String password;
}
