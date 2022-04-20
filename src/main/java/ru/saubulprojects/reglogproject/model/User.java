package ru.saubulprojects.reglogproject.model;

import java.util.Collection;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
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
	
	@NotBlank(message = "Password is required")
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "users_id_fk")),
			inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "role_id_fk"))
			)
	private Collection<Role> roles;
}
