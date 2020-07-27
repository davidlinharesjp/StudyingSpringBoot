package com.davidlinhares.springApplication;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davidlinhares.springApplication.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
