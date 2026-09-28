package com.example.week5;

import com.example.week5.model.User;
import com.example.week5.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Week5Application {

    public static void main(String[] args) {
        SpringApplication.run(Week5Application.class, args);
    }

    @Bean
    CommandLineRunner run(UserRepository repository) {
        return args -> {

            repository.save(
                    new User("Meghana", "meghana@gmail.com")
            );

            repository.save(
                    new User("Anu", "anu@gmail.com")
            );

            System.out.println("Users:");

            repository.findAll()
                    .forEach(System.out::println);
        };
    }
}