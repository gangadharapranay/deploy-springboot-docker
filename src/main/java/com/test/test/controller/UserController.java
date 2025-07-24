package com.test.test.controller;

import com.test.test.models.Student;
import com.test.test.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private StudentService studentService;

    public UserController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllUsers(){
        return studentService.getAllUsers();
    }

    @GetMapping("/sample")
    public String getSampleResponse(){
        return "Yes I am working now then";
    }
}
