package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.loginEntity;

public interface loginJpa extends JpaRepository<loginEntity, Long>{
	
	loginEntity findByUsername(String username);

}
