package com.techlingo.controllers;

import com.techlingo.domain.user.User;
import com.techlingo.dtos.LoginRequestDTO;
import com.techlingo.dtos.RegisterRequestDTO;
import com.techlingo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequestDTO loginRequestDTO) {
        Boolean loginSuccessful = this.userService.login(loginRequestDTO);
        return loginSuccessful ? new ResponseEntity<>(HttpStatus.OK) : ResponseEntity.status(404).body("User not found");
    }

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody RegisterRequestDTO registerRequestDTO) {
        Boolean userCreated = userService.createUser(registerRequestDTO);
        return userCreated ? new ResponseEntity<>(HttpStatus.CREATED) : ResponseEntity.status(400).body("User already exists");
    }
}
