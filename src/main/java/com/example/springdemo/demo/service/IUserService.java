package com.example.springdemo.demo.service;

import com.example.springdemo.demo.dto.UserDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    UserDTO findById(int id);
    UserDTO findByEmail(String email);
    List<UserDTO> findAll();
    List<UserDTO> findAll(Pageable pageable);
}