package com.example.demo8.service;

import java.util.List;

import com.example.demo8.dto.UserDto;
import com.example.demo8.entity.User;

public interface UserService {
    void saveUser(UserDto userDto);
    User findUserByEmail(String email);
    List<UserDto> findAllUsers();
}
