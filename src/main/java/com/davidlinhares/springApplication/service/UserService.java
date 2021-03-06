package com.davidlinhares.springApplication.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.davidlinhares.springApplication.UserRepository;
import com.davidlinhares.springApplication.entities.User;
import com.davidlinhares.springApplication.service.exceptions.DatabaseException;
import com.davidlinhares.springApplication.service.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
		Optional<User> opUser = userRepository.findById(id);
		return opUser.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User obj) {
		return userRepository.save(obj);
	}

	public void delete(Long id) {
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public User update(Long id, User newUser) {
		try {
			User user = userRepository.getOne(id);
			updateDate(user, newUser);
			return userRepository.save(user);
			
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateDate(User user, User newUser) {
		user.setName(newUser.getName());
		user.setEmail(newUser.getEmail());
		user.setPhone(newUser.getPhone());

	}
}
