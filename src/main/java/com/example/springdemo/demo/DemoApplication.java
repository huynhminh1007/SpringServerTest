package com.example.springdemo.demo;

import com.example.springdemo.demo.controller.UserController;
import com.example.springdemo.demo.dto.UserDTO;
import com.example.springdemo.demo.entity.User;
import com.example.springdemo.demo.service.impl.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
	}
}
