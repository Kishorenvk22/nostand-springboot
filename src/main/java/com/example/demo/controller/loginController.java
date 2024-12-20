package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.loginDto;
import com.example.demo.dto.loginUsername;
import com.example.demo.entity.loginEntity;
import com.example.demo.service.loginService;

@RestController
@CrossOrigin(origins = "http://localhost:4200",methods = {RequestMethod.GET,RequestMethod.PATCH,RequestMethod.POST})
@RequestMapping("/api")
public class loginController {

	private loginService loginservice;
	
	@Autowired
	public  loginController(loginService loginService) {
		this.loginservice=loginService;
	}
	
	@GetMapping("/userinfo")
	public List<loginDto> getAllUsers(){
		return loginservice.findAllUsers();
	}
	
	@PostMapping("/user")
	public ResponseEntity<?> findUserName(@RequestBody loginDto logindto) {
		loginEntity loginentity=loginservice.authenticateUser(logindto.getUsername(), logindto.getPassword());
		if(loginentity!=null) {
			return ResponseEntity.ok(new loginUsername(loginentity.getUsername()));
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	}
	 
	@PostMapping("/login")
    public boolean login(@RequestBody loginDto logindto) {
        return loginservice.authenticate(logindto.getUsername(), logindto.getPassword());
    }
	@GetMapping("/test")
	public String getWelcomeMsg(){
		return "Successfully inside heroku";
	}
	
	
}
 