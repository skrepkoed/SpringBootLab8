package com.example.demo8.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo8.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User  findByEmail(String email);
}
