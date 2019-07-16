package com.applaudo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.applaudo.api.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
	
	User findOneByUsername(String username);

}