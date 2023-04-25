package com.assistant.service;

import com.assistant.domain.User;
import com.assistant.domain.UserRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@Import(UserService.class)
class UserServiceTest {

    @Autowired
    private UserService userService;

    private final long userId = 1L;
    private final String userName = "루루루";
    private List<UserRole> userRoles = List.of();

    private final String updatedUserName = "수정된 루";
    private List<UserRole> updatedUserRoles = List.of();
    private User 유저_1번;

    @BeforeEach
    void setUp() {
        유저_1번 = new User(userId, userName, userRoles);
    }

    @Test
    public void 등록한다() {
        User savedUser = userService.save(유저_1번);

        assertEquals(savedUser.getUserId(), userId);
    }

    @Test
    public void 수정한다() {
        User user = userService.save(유저_1번);
        User updatedUser = userService.update(user, updatedUserName, updatedUserRoles);

        assertEquals(updatedUser.getUserName(), updatedUserName);
    }

    @Test
    public void 삭제한다() {
        User user = userService.save(유저_1번);
        userService.delete(user);

        assertNull(userService.findById(유저_1번.getUserId()));
    }

}