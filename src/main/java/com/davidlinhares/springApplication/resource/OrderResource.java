package com.davidlinhares.springApplication.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davidlinhares.springApplication.entities.Order;
import com.davidlinhares.springApplication.service.OrderService;

@RestController
@RequestMapping(value = "/order")
public class OrderResource {

	@Autowired
	private OrderService orderService;

	@RequestMapping(value="/findAll")
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = orderService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {

		Order order = orderService.findById(id);
		return ResponseEntity.ok().body(order);
	}

}
