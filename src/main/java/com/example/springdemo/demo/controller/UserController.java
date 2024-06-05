package com.example.springdemo.demo.controller;

import com.example.springdemo.demo.dto.ApiResponse;
import com.example.springdemo.demo.dto.UserDTO;
import com.example.springdemo.demo.service.impl.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{email}")
    public ApiResponse<UserDTO> findUserByEmail(@PathVariable @Email String email) {
        UserDTO userDTO = userService.findByEmail(email);
        return new ApiResponse<>(HttpStatus.OK.value(), userDTO);
    }
}