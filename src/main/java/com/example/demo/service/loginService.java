package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.dto.loginDto;
import com.example.demo.entity.loginEntity;
import com.example.demo.respository.loginJpa;

@Service
public class loginService {

	@Autowired
	private loginJpa loginjpa;
	
	public List<loginDto> findAllUsers() {
        List<loginEntity> login = loginjpa.findAll();  
        return login.stream()
                .map(l -> new loginDto (l.getId(), l.getUsername(), l.getPassword()))  
                .collect(Collectors.toList());
    }
	
	public boolean authenticate(String username, String password) {
        loginEntity login = loginjpa.findByUsername(username);
        if (login != null && login.getPassword().equals(password)) {
            return true;  // Valid login
        }
        return false;  // Invalid login
    }
	
	public loginEntity authenticateUser(String username,String password){
		
		loginEntity loginUser= loginjpa.findByUsername(username);
		if(loginUser!=null && loginUser.getPassword().equals(password))
			return loginUser;
		
		return null;
		
	}
	

}
