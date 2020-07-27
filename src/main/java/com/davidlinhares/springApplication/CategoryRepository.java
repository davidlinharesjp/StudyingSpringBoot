package com.davidlinhares.springApplication;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davidlinhares.springApplication.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
