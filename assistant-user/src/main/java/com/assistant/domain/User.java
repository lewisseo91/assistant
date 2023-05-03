package com.assistant.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private final Long userId;
    @Column(name = "user_name")
    private final String userName;

    @OneToMany(mappedBy = "userRoleId", fetch = FetchType.LAZY)
    private final List<UserRole> userRoles;

    public User() {
        this.userId = null;
        this.userName = null;
        this.userRoles = new ArrayList<>();
    }

    public User(Long userId, String userName, List<UserRole> userRoles) {
        this.userId = userId;
        this.userName = userName;
        this.userRoles = userRoles;
    }

    public static User create(long userId, String userName, List<UserRole> userRoles) {
        return new User(userId, userName, userRoles);
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public User update(Long userId, String updatedUserName, List<UserRole> updatedUserRoles) {
        return new User(userId, updatedUserName, updatedUserRoles);
    }
}
