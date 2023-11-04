package com.example.demo8.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    Long id;
    @NotEmpty
    String firstName;
    
    @NotEmpty
    String lastName;
    
    @Email
    @NotEmpty(message = "email should not be empty")
    String email;
    @NotEmpty(message = "email should not be empty")
    String password;
}
