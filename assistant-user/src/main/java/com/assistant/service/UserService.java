package com.assistant.service;


import com.assistant.domain.User;
import com.assistant.domain.UserRole;
import com.assistant.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(User user, String updatedUserName, List<UserRole> updatedUserRoles) {
        return user.update(user.getUserId(), updatedUserName, updatedUserRoles);
    }

    public void delete(User user) {
        userRepository.deleteById(user.getUserId());
    }

    public User findById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
