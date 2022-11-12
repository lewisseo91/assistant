package com.assistant.domain;

import java.util.List;

public class User {
    private long userId;
    private String userName;
    private List<UserRole> userRoles;

    public User(long userId, String userName, List<UserRole> userRoles) {
        this.userId = userId;
        this.userName = userName;
        this.userRoles = userRoles;
    }

    public static User create(long userId, String userName, List<UserRole> userRoles) {
        return new User(userId, userName, userRoles);
    }

    public long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public User update(String updatedUserName, List<UserRole> updatedUserRoles) {
        return new User(userId, updatedUserName, updatedUserRoles);
    }
}
