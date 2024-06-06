package com.example.springdemo.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private int id;

    @Email(message = "Email is invalid")
    private String email;

    @Size(max=3, message = "Name is invalid")
    private String name;
}
