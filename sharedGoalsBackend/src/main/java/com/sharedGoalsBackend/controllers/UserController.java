package com.sharedGoalsBackend.controllers;

import com.sharedGoalsBackend.DTOs.UserDTO;
import com.sharedGoalsBackend.entity.User;
import com.sharedGoalsBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

    // Other user-related endpoints
}

