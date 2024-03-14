package com.example.customer.description;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DescriptionConfig {
    @Bean
    CommandLineRunner descriptionCommandLineRunner(DescriptionRepository repository) {
        return args -> {
            Description dc1 = new Description("Ball");
            Description dc2 = new Description("Table");
            Description dc3 = new Description("Noodles");

            repository.saveAll(List.of(dc1, dc2, dc3));
        };
    }
}
