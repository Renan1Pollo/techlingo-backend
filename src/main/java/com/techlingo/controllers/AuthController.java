package com.techlingo.controllers;

import com.techlingo.utils.ResponseHandler;
import com.techlingo.domain.user.UserResponse;
import com.techlingo.dtos.auth.LoginRequestDTO;
import com.techlingo.dtos.auth.RegisterRequestDTO;
import com.techlingo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
        UserResponse userResponse = this.userService.login(loginRequestDTO);
        return ResponseHandler.createResponse(userResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody RegisterRequestDTO registerRequestDTO) {
        UserResponse userResponse = userService.createUser(registerRequestDTO);
        return ResponseHandler.createResponse(userResponse);
    }

    @PostMapping("/register/admin")
    public ResponseEntity<?> createAdmin(@RequestBody RegisterRequestDTO registerRequestDTO) {
        UserResponse userResponse = userService.createAdmin(registerRequestDTO);
        return ResponseHandler.createResponse(userResponse);
    }
}
