package com.example.week8.service;

import com.example.week8.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User getUser() {

        return new User(
                101,
                "Meghana",
                "meghana@gmail.com"
        );
    }
}