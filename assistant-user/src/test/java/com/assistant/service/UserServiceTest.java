package com.assistant.service;

import com.assistant.domain.User;
import com.assistant.domain.UserRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Autowired
    private UserService userService;

    private final long userId = 1L;
    private final String userName = "루루루";
    private final List<UserRole> userRoles = List.of(UserRole.NONE);

    private final String updatedUserName = "수정된 루";
    private final List<UserRole> updatedUserRoles = List.of(UserRole.SUPER);
    private User 유저_1번;

    @BeforeEach
    void setUp() {
        유저_1번 = new User(userId, userName, userRoles);
    }

    @Test
    public void 등록한다() {
        userService.save(유저_1번);
    }

    @Test
    public void 수정한다() {
        User user = userService.save(유저_1번);
        userService.update(user, updatedUserName, updatedUserRoles);
    }

    @Test
    public void 삭제한다() {
        User user = userService.save(유저_1번);
        userService.delete(user);
    }

}