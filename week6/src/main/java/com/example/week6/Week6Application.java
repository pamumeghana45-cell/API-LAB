package com.example.week6;

import com.example.week6.model.User;
import com.example.week6.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Week6Application {

    public static void main(String[] args) {
        SpringApplication.run(Week6Application.class, args);
    }

    @Bean
    CommandLineRunner run(UserRepository repository) {
        return args -> {

            repository.save(new User("Meghana", "meghana@gmail.com"));
            repository.save(new User("Anu", "anu@gmail.com"));
            repository.save(new User("Ravi", "ravi@gmail.com"));
            repository.save(new User("Sita", "sita@gmail.com"));
            repository.save(new User("Kiran", "kiran@gmail.com"));

            System.out.println("Users:");

            repository.findAll().forEach(System.out::println);
        };
    }
}