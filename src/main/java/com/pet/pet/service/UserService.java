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

    public User createUser(User user) {
        // Business logic to validate user data can be added here
        return userRepository.save(user);
    }

    public Optional<User> findUserById(String id) {
        return userRepository.findById(id);
    }

    public User registerUser(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            // Log the exception
            System.out.println("Error occurred while registering the user: " + e.getMessage());
            // Optionally, you can throw a custom exception here
            throw new RuntimeException("Could not register the user");
        }
    }
}

