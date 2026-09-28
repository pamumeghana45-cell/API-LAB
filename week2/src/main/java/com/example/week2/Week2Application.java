package com.example.week2;

import com.example.week2.model.Product;
import com.example.week2.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Week2Application {

    public static void main(String[] args) {
        SpringApplication.run(Week2Application.class, args);
    }

    @Bean
    CommandLineRunner run(ProductRepository repository) {
        return args -> {

            repository.createTable();

            repository.save(new Product(1, "Laptop", 55000));
            repository.save(new Product(2, "Mobile", 25000));
            repository.save(new Product(3, "Headphones", 3000));

            System.out.println("Products:");

            repository.findAll().forEach(System.out::println);
        };
    }
}