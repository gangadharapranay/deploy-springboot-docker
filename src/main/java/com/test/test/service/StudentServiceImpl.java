package com.test.test.service;


import com.test.test.models.Student;
import com.test.test.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public List<Student> getAllUsers() {
        return studentRepository.findAll();
    }

}
