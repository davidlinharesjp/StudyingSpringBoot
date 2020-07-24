package com.davidlinhares.springApplication.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.davidlinhares.springApplication.OrderRepository;
import com.davidlinhares.springApplication.UserRepository;
import com.davidlinhares.springApplication.entities.Order;
import com.davidlinhares.springApplication.entities.User;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	// O metodo rum e chamdo ao inicia o programa e tudo que estiver
	// dentro do run vai ser chamado
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "David linhares", "emai@teste.com", "874-4545", "1234");
		User u2 = new User(null, "Carlos Alberto", "testi@teste.com", "27445-4545", "1564234");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}

}
