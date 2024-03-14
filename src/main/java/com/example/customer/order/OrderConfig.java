package com.example.customer.order;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class OrderConfig {

    @Bean
    CommandLineRunner orderCommandLineRunner(OrderRepository repository) {
        return args -> {
            Order order1 = new Order(LocalDate.of(2001, 1, 1));
            Order order2 = new Order(LocalDate.of(2002, 2, 2));
            Order order3 = new Order(LocalDate.of(2003, 3, 3));

            repository.saveAll(List.of(order1, order2, order3));
        };
    }
}
