package com.davidlinhares.springApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davidlinhares.springApplication.ProductRepository;
import com.davidlinhares.springApplication.entities.Product;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> opProduct = productRepository.findById(id);
		return opProduct.get();
	}
}
