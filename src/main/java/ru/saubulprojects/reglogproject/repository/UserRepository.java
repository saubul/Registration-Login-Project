package ru.saubulprojects.reglogproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.saubulprojects.reglogproject.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	
	
}
