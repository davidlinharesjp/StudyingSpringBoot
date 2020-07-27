package com.davidlinhares.springApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davidlinhares.springApplication.CategoryRepository;
import com.davidlinhares.springApplication.entities.Category;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> opCategory = categoryRepository.findById(id);
		return opCategory.get();

	}
}
