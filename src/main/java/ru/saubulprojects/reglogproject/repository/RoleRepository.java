package ru.saubulprojects.reglogproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.saubulprojects.reglogproject.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	
}
