package com.example.springdemo.demo.mapper;

import com.example.springdemo.demo.dto.UserDTO;
import com.example.springdemo.demo.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toUserDTO(User user);
    List<UserDTO> toUserDTOList(List<User> userList);
}