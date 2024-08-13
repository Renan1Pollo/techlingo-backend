package com.techlingo.services;

import com.techlingo.domain.user.User;
import com.techlingo.dtos.auth.LoginRequestDTO;
import com.techlingo.dtos.auth.RegisterRequestDTO;
import com.techlingo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public Boolean login(LoginRequestDTO data) {
        Optional<User> userOptional = this.repository.findUserByEmail(data.email());

        if (userOptional.isEmpty()) {
            return false;
        }

        User user = userOptional.get();
        return user.getEmail().equals(data.email()) && user.getPassword().equals(data.password());
    }

    public Boolean createUser(RegisterRequestDTO data) {
        Optional<User> userOptional = this.repository.findUserByEmail(data.email());

        if (userOptional.isEmpty()) {
            return false;
        }

        User newUser = new User(data);
        repository.save(newUser);
        return true;
    }

    public Boolean decreaseLifes(Long userId, Integer lifesToLose) {
        Optional<User> userOptional = findUserById(userId);

        if (userOptional.isPresent()) {
            return false;
        }

        User user = userOptional.get();
        user.setLifes(user.getLifes() - lifesToLose);
        repository.save(user);
        return true;
    }

    public Boolean increaseScore(Long userId, BigDecimal points) {
        Optional<User> userOptional = findUserById(userId);

        if (userOptional.isEmpty()) {
            return false;
        }

        User user = userOptional.get();
        user.setScore(user.getScore().add(points));
        repository.save(user);
        return true;
    }

    public Boolean updatePassword(Long id, String password) {
        Optional<User> userOptional = findUserById(id);

        if (userOptional.isEmpty()) {
            return false;
        }

        User user = userOptional.get();
        user.setPassword(password);
        repository.save(user);
        return true;
    }

    public Optional<User> findUserById(Long id) {
        return this.repository.findUserById(id);
    }

    public List<User> getAllUsers() {
        return this.repository.findAll();
    }

}
