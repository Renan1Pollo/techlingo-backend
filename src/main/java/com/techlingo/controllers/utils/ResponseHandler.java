package com.techlingo.controllers.utils;

import com.techlingo.domain.user.UserPasswordUpdateStatus;
import com.techlingo.domain.user.UserUpdateStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class ResponseHandler {

    private static final Map<UserUpdateStatus, Supplier<ResponseEntity<?>>> userUpdateResponseMap = new EnumMap<>(UserUpdateStatus.class);
    private static final Map<UserPasswordUpdateStatus, Supplier<ResponseEntity<?>>> userPasswordResponseMap = new EnumMap<>(UserPasswordUpdateStatus.class);

    static {
        // Mapeamento para UserUpdateStatus
        userUpdateResponseMap.put(UserUpdateStatus.SUCCESS, () -> ResponseEntity.ok().build());
        userUpdateResponseMap.put(UserUpdateStatus.NOT_FOUND, () -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found"));

        // Mapeamento para UserPasswordUpdateStatus
        userPasswordResponseMap.put(UserPasswordUpdateStatus.SUCCESS, () -> ResponseEntity.ok().build());
        userPasswordResponseMap.put(UserPasswordUpdateStatus.INCORRECT_PASSWORD, () -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Incorrect password"));
        userPasswordResponseMap.put(UserPasswordUpdateStatus.USER_NOT_FOUND, () -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found"));
    }

    public static ResponseEntity<?> createResponse(UserUpdateStatus status) {
        return userUpdateResponseMap.getOrDefault(status, () -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unknown status")).get();
    }

    public static ResponseEntity<?> createResponse(UserPasswordUpdateStatus status) {
        return userPasswordResponseMap.getOrDefault(status, () -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unknown status")).get();
    }
}
