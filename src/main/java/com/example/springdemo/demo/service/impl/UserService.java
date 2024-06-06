package com.example.springdemo.demo.service.impl;

import com.example.springdemo.demo.dto.UserDTO;
import com.example.springdemo.demo.entity.User;
import com.example.springdemo.demo.exception.user.UserNotFoundException;
import com.example.springdemo.demo.mapper.UserMapper;
import com.example.springdemo.demo.repository.UserRepository;
import com.example.springdemo.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO findById(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());
        return userMapper.toUserDTO(user);
    }

    @Override
    public UserDTO findByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException());
        return userMapper.toUserDTO(user);
    }

    @Override
    public List<UserDTO> findAll() {
        return userMapper.toUserDTOList(userRepository.findAll());
    }

    @Override
    public List<UserDTO> findAll(Pageable pageable) {
        Page<User> userPage = userRepository.findAll(pageable);
        return userMapper.toUserDTOList(userPage.getContent());
    }

    public void delete(int id) {
        userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());
        userRepository.deleteById(id);
    }
}