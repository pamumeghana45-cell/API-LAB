package com.example.week4.controller;

import com.example.week4.model.Student;
import com.example.week4.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public Student getStudent() {
        return studentService.getStudent();
    }
}