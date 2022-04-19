package ru.saubulprojects.reglogproject.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "First name is required")
	@Size(min = 2, message = "Length of first name must be at least 2 symbols")
	@Column(name = "first_name")
	private String firstName;
	
	@NotBlank(message = "Last name is required")
	@Size(min = 2, message = "Length of last name must be at least 2 symbols")
	@Column(name = "last_name")
	private String lastName;
	
	@Email(message = "Wrong email")
	@NotBlank(message = "Email is required")
	@Column(unique = true)
	private String email;
	
	private String password;
	
	private Collection<Role> roles;
}
