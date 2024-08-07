package com.techlingo.controllers;

import com.techlingo.domain.user.User;
import com.techlingo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/{userId}")
    public ResponseEntity<?> updatePassword(@PathVariable Long userId, @RequestParam String password) {
        Boolean isUpdated = this.userService.updatePassword(userId, password);
        return isUpdated ? new ResponseEntity<>(HttpStatus.OK) : ResponseEntity.status(404).body("User not found");
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = this.userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
