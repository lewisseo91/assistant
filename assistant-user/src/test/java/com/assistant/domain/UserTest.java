package com.assistant.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void 등록한다() {
        long userId = 1;
        String userName = "루루루";
        List<UserRole> userRoles = List.of(new UserRole(1L, userId, UserRoleType.NONE));
        User user = User.create(userId, userName, userRoles);

        assertEquals(userName, user.getUserName());
        assertIterableEquals(userRoles, user.getUserRoles());
    }

    @Test
    public void 수정한다() {
        long userId = 1;
        String userName = "루루루";
        List<UserRole> userRoles = List.of(new UserRole(1L, userId, UserRoleType.NONE));
        User user = User.create(userId, userName, userRoles);

        String updatedUserName = "수정된 루";
        List<UserRole> updatedUserRoles = List.of(new UserRole(2L, userId, UserRoleType.SUPER));
        User updatedUser = user.update(userId, updatedUserName, updatedUserRoles);

        assertEquals(updatedUserName, updatedUser.getUserName());
        assertIterableEquals(updatedUserRoles, updatedUser.getUserRoles());
    }

}