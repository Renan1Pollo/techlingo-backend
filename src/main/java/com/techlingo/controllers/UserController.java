package com.techlingo.controllers;

import com.techlingo.controllers.utils.ResponseHandler;
import com.techlingo.domain.user.User;
import com.techlingo.domain.user.UserPasswordUpdateStatus;
import com.techlingo.domain.user.UserResponse;
import com.techlingo.domain.user.UserUpdateStatus;
import com.techlingo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/{userId}/password")
    public ResponseEntity<?> updatePassword(@PathVariable Long userId, @RequestParam String oldPassword, @RequestParam String newPassword) {
        UserPasswordUpdateStatus status = userService.updatePassword(userId, oldPassword, newPassword);
        return ResponseHandler.createResponse(status);
    }

    @PutMapping("/{userId}/lives")
    public ResponseEntity<?> updateUserLives(@PathVariable Long userId, @RequestParam Integer liveCount) {
        UserUpdateStatus status = userService.updateLives(userId, liveCount);
        return ResponseHandler.createResponse(status);
    }

    @PutMapping("/{userId}/score")
    public ResponseEntity<?> increaseScore(@PathVariable Long userId, @RequestParam BigDecimal points) {
        UserResponse status = userService.increaseScore(userId, points);
        return ResponseHandler.createResponse(status);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}