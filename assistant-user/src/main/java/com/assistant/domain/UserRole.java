package com.assistant.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private final Long userRoleId;

    @Column(name = "user_id")
    private final Long userId;

    @Column(name = "role_type")
    @Enumerated(value = EnumType.STRING)
    private final UserRoleType roleType;

    public UserRole() {
        this.userRoleId = null;
        this.userId = null;
        this.roleType = null;
    }

    public UserRole(Long userRoleId, Long userId, UserRoleType roleType) {
        this.userRoleId = userRoleId;
        this.userId = userId;
        this.roleType = roleType;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public Long getUserId() {
        return userId;
    }

    public UserRoleType getRoleType() {
        return roleType;
    }
}
