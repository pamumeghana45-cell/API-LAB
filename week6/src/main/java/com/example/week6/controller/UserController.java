package com.example.week6.controller;

import com.example.week6.model.User;
import com.example.week6.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Pagination and normal sorting
    @GetMapping("/users")
    public Page<User> getUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size,
            @RequestParam(defaultValue = "id") String sortBy) {

        Pageable pageable =
                PageRequest.of(page, size, Sort.by(sortBy).ascending());

        return userRepository.findAll(pageable);
    }

    // Custom sorting using @Query
    @GetMapping("/users/sorted")
    public Page<User> getSortedUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size) {

        Pageable pageable = PageRequest.of(page, size);

        return userRepository.findAllSortedByName(pageable);
    }
}