package com.example.customer.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner productCommandLineRunner(ProductRepository repository) {
        return args -> {
            Product soccer_ball = new Product("Soccer Ball", 20);
            Product coffee_table = new Product("Coffee Table", 50);
            Product ramen_noodles = new Product("Ramen Noodles", 2);

            repository.saveAll(List.of(soccer_ball, coffee_table, ramen_noodles));
        };
    }
}
