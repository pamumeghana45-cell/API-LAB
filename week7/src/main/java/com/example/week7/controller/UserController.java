package com.example.week7.controller;

import com.example.week7.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final List<User> users = new ArrayList<>();

    public UserController() {
        users.add(new User(1, "Meghana", "meghana@gmail.com"));
        users.add(new User(2, "Anu", "anu@gmail.com"));
    }

    // GET - Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return users;
    }

    // GET - Get user by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {

        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }

        return null;
    }

    // POST - Add new user
    @PostMapping
    public User addUser(@RequestBody User user) {
        users.add(user);
        return user;
    }

    // PUT - Update user
    @PutMapping("/{id}")
    public User updateUser(
            @PathVariable int id,
            @RequestBody User updatedUser) {

        for (User user : users) {
            if (user.getId() == id) {
                user.setName(updatedUser.getName());
                user.setEmail(updatedUser.getEmail());
                return user;
            }
        }

        return null;
    }

    // DELETE - Delete user
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {

        users.removeIf(user -> user.getId() == id);

        return "User deleted successfully";
    }
}