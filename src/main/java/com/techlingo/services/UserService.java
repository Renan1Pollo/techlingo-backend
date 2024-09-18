package com.techlingo.services;

import com.techlingo.domain.user.User;
import com.techlingo.domain.user.UserPasswordUpdateStatus;
import com.techlingo.domain.user.UserUpdateStatus;
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

    public UserUpdateStatus updateLives(Long userId, Integer livesToLose) {
        Optional<User> userOptional = findUserById(userId);

        if (userOptional.isEmpty()) {
            return UserUpdateStatus.NOT_FOUND;
        }

        User user = userOptional.get();
        user.setLives(livesToLose);
        repository.save(user);
        return UserUpdateStatus.SUCCESS;
    }

    public UserUpdateStatus increaseScore(Long userId, BigDecimal points) {
        Optional<User> userOptional = findUserById(userId);

        if (userOptional.isEmpty()) {
            return UserUpdateStatus.NOT_FOUND;
        }

        User user = userOptional.get();
        user.setScore(user.getScore().add(points));
        repository.save(user);
        return UserUpdateStatus.SUCCESS;
    }

    public UserPasswordUpdateStatus updatePassword(Long id, String oldPassword, String newPassword) {
        Optional<User> userOptional = findUserById(id);

        if (userOptional.isEmpty()) {
            return UserPasswordUpdateStatus.USER_NOT_FOUND;
        }

        User user = userOptional.get();
        if (user.getPassword().equals(oldPassword)) {
            user.setPassword(newPassword);
            repository.save(user);
            return UserPasswordUpdateStatus.SUCCESS;
        }

        return UserPasswordUpdateStatus.INCORRECT_PASSWORD;
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
