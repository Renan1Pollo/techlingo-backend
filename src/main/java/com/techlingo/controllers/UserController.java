package com.techlingo.controllers;

import com.techlingo.domain.user.User;
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
    public ResponseEntity<?> updatePassword(@PathVariable Long userId, @RequestParam String password) {
        boolean isUpdated = userService.updatePassword(userId, password);
        return buildResponse(isUpdated, "User not found");
    }

    @PutMapping("/{userId}/lifes/decrease")
    public ResponseEntity<?> decreaseLifes(@PathVariable Long userId, @RequestParam int lifesToLose) {
        boolean isUpdated = userService.decreaseLives(userId, lifesToLose);
        return buildResponse(isUpdated, "User not found");
    }

    @PutMapping("/{userId}/score/increase")
    public ResponseEntity<?> increaseScore(@PathVariable Long userId, @RequestParam BigDecimal points) {
        boolean isUpdated = userService.increaseScore(userId, points);
        return buildResponse(isUpdated, "User not found");
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    private ResponseEntity<?> buildResponse(boolean condition, String errorMessage) {
        return condition ? ResponseEntity.ok().build() : ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}