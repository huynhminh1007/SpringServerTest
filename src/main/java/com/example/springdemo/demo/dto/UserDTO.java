package com.example.springdemo.demo.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class UserDTO {

    private int id;

    @Email
    private String email;

    private String name;
}
