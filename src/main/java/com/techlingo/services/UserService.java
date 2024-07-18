package com.techlingo.services;

import com.techlingo.domain.user.User;
import com.techlingo.dtos.LoginRequestDTO;
import com.techlingo.dtos.RegisterRequestDTO;
import com.techlingo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User createUser(RegisterRequestDTO data) {
        User newUser = new User(data);
        repository.save(newUser);
        return newUser;
    }

    public Boolean login(LoginRequestDTO data) {
        Optional<User> userOptional = this.repository.findUserByEmail(data.email());

        if (!userOptional.isPresent()) {
            return false;
        }

        User user = userOptional.get();
        return user.getEmail().equals(data.email()) && user.getPassword().equals(data.password());
    }

    public Boolean updatePassword(Long id, String password) {
        Optional<User> userOptional = findUserById(id);

        if (userOptional.isPresent()) {
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
