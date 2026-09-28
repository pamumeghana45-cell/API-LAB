package com.example.week4.service;

import com.example.week4.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public Student getStudent() {
        return new Student(101, "Meghana", "AI & ML");
    }
}