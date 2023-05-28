package com.pet.pet.controller;

import com.pet.pet.controller.model.UserCreateRequest;
import com.pet.pet.model.Interaction;
import com.pet.pet.model.Pet;
import com.pet.pet.model.User;
import com.pet.pet.service.PetService;
import com.pet.pet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;
    private final PetService petService;

    @Autowired
    public UserController(UserService userService, PetService petService) {
        this.userService = userService;
        this.petService = petService;
    }

    @PostMapping("/users")
    public ResponseEntity<String> registerUser(@RequestBody UserCreateRequest userCreateRequest) {
        if (userCreateRequest.getName() == null || userCreateRequest.getName().trim().isEmpty()) {
            return new ResponseEntity<>("Username cannot be empty", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setName(userCreateRequest.getName());

        try {
            userService.registerUser(user);
            return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred while registering the user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/pets")
    public ResponseEntity<String> adoptPet(@RequestBody Pet pet) {
        try {
            petService.adoptPet(pet);
            return new ResponseEntity<>("Pet adopted successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred while adopting the pet: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pets")
    public ResponseEntity<List<Pet>> listPets(@RequestParam String userId) {
        try {
            List<Pet> pets = petService.listPets(userId);
            return new ResponseEntity<>(pets, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/pets/{petId}")
    public ResponseEntity<String> interactWithPet(@PathVariable String petId, @RequestBody Interaction interaction) {
        try {
            petService.interactWithPet(petId, interaction);
            return new ResponseEntity<>("Pet interaction successful", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred while interacting with the pet: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/pets/{petId}/play")
    public ResponseEntity<String> playWithPet(@PathVariable String petId) {
        try {
            petService.playWithPet(petId);
            return new ResponseEntity<>("Played with pet successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred while playing with the pet: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/pets/{petId}/feed")
    public ResponseEntity<String> feedPet(@PathVariable String petId) {
        try {
            petService.feedPet(petId);
            return new ResponseEntity<>("Fed pet successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred while feeding the pet: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/pets/{petId}/groom")
    public ResponseEntity<String> groomPet(@PathVariable String petId) {
        try {
            petService.groomPet(petId);
            return new ResponseEntity<>("Groomed pet successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred while grooming the pet: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pets/{petId}/health")
    public ResponseEntity<Integer> getPetHealth(@PathVariable String petId) {
        try {
            Integer petHealth = petService.getPetHealth(petId);
            if(petHealth != null) {
                return new ResponseEntity<>(petHealth, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
