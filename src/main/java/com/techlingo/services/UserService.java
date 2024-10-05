package com.techlingo.services;

import com.techlingo.domain.user.User;
import com.techlingo.domain.user.UserPasswordUpdateStatus;
import com.techlingo.domain.user.UserResponse;
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

    public UserResponse login(LoginRequestDTO data) {
        Optional<User> userOptional = this.repository.findUserByEmail(data.email());

        if (userOptional.isEmpty()) {
            return new UserResponse(UserPasswordUpdateStatus.USER_NOT_FOUND, null);
        }

        User user = userOptional.get();
        if (user.getPassword().equals(data.password())) {
            updateLivesBasedOnLastAccess(user);
            return new UserResponse(UserPasswordUpdateStatus.SUCCESS, user);
        }

        return new UserResponse(UserPasswordUpdateStatus.INCORRECT_PASSWORD, null);
    }

    public UserResponse createUser(RegisterRequestDTO data) {
        Optional<User> userOptional = this.repository.findUserByEmail(data.email());

        if (userOptional.isPresent()) {
            return new UserResponse(UserUpdateStatus.ALREADY_EXISTS, null);
        }

        User newUser = new User(data, false);
        repository.save(newUser);
        return new UserResponse(UserUpdateStatus.SUCCESS, newUser);
    }

    public UserResponse createAdmin(RegisterRequestDTO data) {
        Optional<User> userOptional = this.repository.findUserByEmail(data.email());

        if (userOptional.isPresent()) {
            return new UserResponse(UserUpdateStatus.ALREADY_EXISTS, null);
        }

        User newAdmin = new User(data, true);
        repository.save(newAdmin);
        return new UserResponse(UserUpdateStatus.SUCCESS, newAdmin);
    }

    public UserResponse updateLives(Long userId, Integer livesToLose) {
        Optional<User> userOptional = findUserById(userId);

        if (userOptional.isEmpty()) {
            return new UserResponse(UserUpdateStatus.NOT_FOUND, null);
        }

        User user = userOptional.get();
        user.setLives(livesToLose);
        repository.save(user);
        return new UserResponse(UserUpdateStatus.SUCCESS, user);
    }

    public UserResponse increaseScore(Long userId, BigDecimal points) {
        Optional<User> userOptional = findUserById(userId);

        if (userOptional.isEmpty()) {
            return new UserResponse(UserUpdateStatus.NOT_FOUND, null);
        }

        User user = userOptional.get();
        user.setScore(user.getScore().add(points));
        repository.save(user);
        return new UserResponse(UserUpdateStatus.SUCCESS, user);
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
