package com.techlingo.controllers;

import com.techlingo.domain.user.User;
import com.techlingo.dtos.auth.LoginRequestDTO;
import com.techlingo.dtos.auth.RegisterRequestDTO;
import com.techlingo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequestDTO loginRequestDTO) {
        Optional<User> userOptional = this.userService.login(loginRequestDTO);
        return userOptional.isPresent() ? new ResponseEntity<>(userOptional.get(), HttpStatus.OK) : ResponseEntity.status(404).body("User not found");
    }

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody RegisterRequestDTO registerRequestDTO) {
        Optional<User> userOptional = userService.createUser(registerRequestDTO);
        return userOptional.isPresent() ? new ResponseEntity<>(userOptional.get(), HttpStatus.CREATED) : ResponseEntity.status(400).body("User already exists");
    }

    @PostMapping("/register/admin")
    public ResponseEntity<?> createAdmin(@RequestBody RegisterRequestDTO registerRequestDTO) {
        Optional<User> userOptional = userService.createAdmin(registerRequestDTO);
        return userOptional.isPresent() ? new ResponseEntity<>(userOptional.get(), HttpStatus.CREATED) : ResponseEntity.status(400).body("Admin already exists");
    }
}
