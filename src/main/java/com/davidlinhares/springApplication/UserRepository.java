package com.davidlinhares.springApplication;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davidlinhares.springApplication.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
