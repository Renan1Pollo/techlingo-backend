package com.techlingo.services;

import com.techlingo.domain.user.User;
import com.techlingo.dtos.RegisterRequestDTO;
import com.techlingo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User createUser(RegisterRequestDTO data) {
        User newUser = new User(data);
        repository.save(newUser);
        return newUser;
    }

}
