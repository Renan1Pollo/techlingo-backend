package com.techlingo.services;

import com.techlingo.domain.user.User;
import com.techlingo.dtos.auth.LoginRequestDTO;
import com.techlingo.dtos.auth.RegisterRequestDTO;
import com.techlingo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public Optional<User> login(LoginRequestDTO data) {
        Optional<User> userOptional = this.repository.findUserByEmail(data.email());

        if (userOptional.isPresent() && userOptional.get().getPassword().equals(data.password())) {
            User user = userOptional.get();
            updateLivesBasedOnLastAccess(user);
            return Optional.of(user);
        }

        return Optional.empty();
    }

    public Optional<User> createUser(RegisterRequestDTO data) {
        Optional<User> userOptional = this.repository.findUserByEmail(data.email());

        if (userOptional.isPresent()) {
            return Optional.empty();
        }

        User newUser = new User(data, false);
        repository.save(newUser);
        return Optional.of(newUser);
    }

    public Optional<User> createAdmin(RegisterRequestDTO data) {
        Optional<User> userOptional = this.repository.findUserByEmail(data.email());

        if (userOptional.isPresent()) {
            return Optional.empty();
        }

        User newUser = new User(data, true);
        repository.save(newUser);
        return Optional.of(newUser);
    }

    public Boolean decreaseLives(Long userId, Integer livesToLose) {
        Optional<User> userOptional = findUserById(userId);

        if (userOptional.isEmpty()) {
            return false;
        }

        User user = userOptional.get();
        user.setLives(livesToLose);
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

    private void updateLivesBasedOnLastAccess(User user) {
        LocalDateTime lastAccess = user.getLastAccessDate();
        LocalDateTime now = LocalDateTime.now();
        long minutesPassed = Duration.between(lastAccess, now).toMinutes();

        if (minutesPassed >= 10) {
            int livesToAdd = (int) (minutesPassed / 10);
            user.setLives(Math.min(user.getLives() + livesToAdd, 5));

            if (livesToAdd > 0) {
                user.setLastAccessDate(now);
                this.repository.save(user);
            }
        }
    }

    public Optional<User> findUserById(Long id) {
        return this.repository.findUserById(id);
    }

    public List<User> getAllUsers() {
        return this.repository.findAll();
    }

}
