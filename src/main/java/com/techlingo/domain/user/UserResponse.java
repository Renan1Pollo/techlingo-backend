package com.techlingo.domain.user;

import lombok.*;

@Getter
@Setter
public class UserResponse {

    private UserPasswordUpdateStatus userPasswordUpdateStatus;
    private UserUpdateStatus userUpdateStatus;
    private User user;

    public UserResponse(UserUpdateStatus status, User user) {
        this.userUpdateStatus = status;
        this.user = user;
    }

    public UserResponse(UserPasswordUpdateStatus userPasswordUpdateStatus, User user) {
        this.userPasswordUpdateStatus = userPasswordUpdateStatus;
        this.user = user;
    }
}
