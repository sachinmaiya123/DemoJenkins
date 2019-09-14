package com.quinnox.service.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quinnox.service.entity.DGUser;
import com.quinnox.service.serviceImpl.DGUserService;

import javassist.compiler.SyntaxError;

@RestController
@RequestMapping("/rest/user")
public class UserRegistrationController {

	@Autowired
	private DGUserService service;
	
	@PostMapping(value="/register",consumes = "application/json")
	public String registerUser(@RequestBody DGUser user) {
		Date date = new Date();
		long userId = date.getTime();
		user.setId(userId);
		try {
			userId = service.addUser(user);
		}catch(Exception e) {
			e.printStackTrace();
			return "error while registering user";
		}
		return "user registered successfully with userId = "+ userId;
	}
	
	@GetMapping(value="/getAllUsers")
	public List<DGUser> getAllUsers(){
		return service.getAllUsers();
	}
	
}
