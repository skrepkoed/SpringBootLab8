package com.example.demo8.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo8.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
    
}
