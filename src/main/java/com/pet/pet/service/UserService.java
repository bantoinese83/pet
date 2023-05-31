package com.pet.pet.service;

import com.pet.pet.controller.UserRecord;
import com.pet.pet.model.User;
import com.pet.pet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean createUser(String email, String password) {
        System.out.println("Creating user with email: " + email);
        Optional<UserRecord> existingUser = userRepository.findById(email);
        if (existingUser.isPresent()) {
            return false; // User with the given email already exists
        }

        UserRecord userRecord = new UserRecord(email, hash(password));
        userRepository.save(userRecord);
        return true;
    }

    public User login(String email, String password) {
        Optional<UserRecord> userRecordOptional = userRepository.findById(email);
        if (userRecordOptional.isPresent()) {
            UserRecord userRecord = userRecordOptional.get();
            if (userRecord.getPassword().equals(hash(password))) {
                return new User(userRecord.getEmail(), userRecord.getPassword());
            }
        }
        return null;
    }

    public Optional<UserRecord> getUser(String email) {
        return userRepository.findById(Objects.requireNonNull(hash(email)));
    }

    public boolean checkEmailUniqueness(String email) {
        return !userRepository.existsById(Objects.requireNonNull(hash(email)));
    }

    public Iterable<UserRecord> getAllUsers() {
        return userRepository.findAll();
    }

    public boolean deleteUserByEmail(String email) {
        if (userRepository.existsById(Objects.requireNonNull(hash(email)))) {
            userRepository.deleteById(Objects.requireNonNull(hash(email)));
            return true;
        }
        return false;
    }

    public boolean updateUserByEmail(String email, String password) {
        Optional<UserRecord> record = userRepository.findById(Objects.requireNonNull(hash(email)));
        if (record.isPresent()) {
            UserRecord userRecord = record.get();
            userRecord.setPassword(password);
            userRepository.save(userRecord);
            return true;
        }
        return false;
    }

    public boolean userExists(String ownerId) {
        return userRepository.existsById(ownerId);
    }

    // Helper method to hash the email or password
    private String hash(String value) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(value.getBytes(StandardCharsets.UTF_8));

            // Convert the byte array to a hexadecimal string representation
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean validateCredentials(String email, String password) {
        Optional<UserRecord> record = userRepository.findById(Objects.requireNonNull(hash(email)));
        if (record.isPresent()) {
            UserRecord userRecord = record.get();
            return userRecord.getPassword().equals(password);
        }
        return false;
    }
}
