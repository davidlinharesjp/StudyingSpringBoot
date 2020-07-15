package com.davidlinhares.springApplication.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davidlinhares.springApplication.entities.User;

@RestController
@RequestMapping(value = "/user")
public class UserResource {
	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "David", "david@linhares.com", "987518465", "***");
		return ResponseEntity.ok().body(u);
	}

}
