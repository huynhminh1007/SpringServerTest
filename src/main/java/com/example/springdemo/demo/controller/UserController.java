package com.example.springdemo.demo.controller;

import com.example.springdemo.demo.dto.ApiResponse;
import com.example.springdemo.demo.dto.UserDTO;
import com.example.springdemo.demo.service.impl.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findByEmail")
    public ResponseEntity<ApiResponse<UserDTO>> findUserByEmail(@RequestParam @Email String email) {
        UserDTO userDTO = userService.findByEmail(email);
        return ResponseEntity.ok(new ApiResponse<>(userDTO));
    }

    @GetMapping("/findById")
    public ResponseEntity<ApiResponse<UserDTO>> findUserById(@RequestParam Integer id) {
        UserDTO userDTO = userService.findById(id);
        return ResponseEntity.ok(new ApiResponse<>(userDTO));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserDTO>>> findUserList(
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "1", required = false) int size,
            @RequestParam(defaultValue = "id", required = false) String orderBy,
            @RequestParam(defaultValue = "asc", required = false) String orderDir) {

        Pageable pageable = PageRequest.of(page, size,
                Sort.by(new Sort.Order(Sort.Direction.fromString(orderDir), orderBy)));

        return ResponseEntity.ok(new ApiResponse<>(userService.findAll(pageable)));
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResponse> updatePassword(@RequestBody @Valid UserDTO userDTO) {
        return ResponseEntity.ok(new ApiResponse("Cập nhật mật khẩu thành công"));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse> deleteUser(@RequestParam Integer id) {
        userService.delete(id);
        return ResponseEntity.ok(new ApiResponse("User deleted successfully"));
    }
}