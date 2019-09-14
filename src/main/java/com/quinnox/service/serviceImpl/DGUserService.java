package com.quinnox.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quinnox.service.entity.DGUser;
import com.quinnox.service.repository.UserRepository;

@Component
public class DGUserService {
	
	public DGUserService() {
		System.err.println("service autowired...");
	}

	@Autowired
	private UserRepository userRepository;
	
	public long addUser(DGUser user) {
		return userRepository.save(user).getId();
	}
	
	public List<DGUser> getAllUsers(){
		return userRepository.findAll();
	}
}
