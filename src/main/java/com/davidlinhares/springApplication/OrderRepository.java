package com.davidlinhares.springApplication;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davidlinhares.springApplication.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
