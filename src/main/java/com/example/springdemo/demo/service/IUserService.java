package com.example.springdemo.demo.service;

import com.example.springdemo.demo.dto.UserDTO;
import com.example.springdemo.demo.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    UserDTO findById(Integer id);
    UserDTO findByEmail(String email);
    List<UserDTO> findAll();
    List<UserDTO> findAll(Pageable pageable);
}