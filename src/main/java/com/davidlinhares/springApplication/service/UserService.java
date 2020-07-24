package com.davidlinhares.springApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davidlinhares.springApplication.UserRepository;
import com.davidlinhares.springApplication.entities.User;

@Service
public class UserService  {

	@Autowired
	private UserRepository userRepository;
	
	public  List<User> findAll(){
		return  userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> opUser = userRepository.findById(id);
		return opUser.get();
	}
}
