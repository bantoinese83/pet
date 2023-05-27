package com.pet.pet.service;

import com.pet.pet.model.User;
import com.pet.pet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findUserById(String id) {
        return userRepository.findById(id);
    }

    public void registerUser(User user) {
        // Business logic to validate user data can be added here
        userRepository.save(user);
    }

    // Additional methods for user management can be added here
}
