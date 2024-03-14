package com.example.customer.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner customerCommandLineRunner(CustomerRepository repository) {
        return args -> {
            Customer adrian = new Customer("Adrian", "123456", LocalDate.of(2005,6,13));
            Customer mina = new Customer("Mina", "112233", LocalDate.of(2005,7,18));
            Customer idk = new Customer("IDK", "000001", LocalDate.of(1999, 12, 31));

            repository.saveAll(List.of(adrian, mina, idk));
        };
    }
}
