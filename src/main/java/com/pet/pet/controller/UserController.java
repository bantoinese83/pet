package com.pet.pet.controller;

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
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            return new ResponseEntity<>("Username cannot be empty", HttpStatus.BAD_REQUEST);
        }

        if (user.getId() == null || user.getId().trim().isEmpty()) {
            return new ResponseEntity<>("Password cannot be empty", HttpStatus.BAD_REQUEST);
        }

        try {
            userService.registerUser(user);
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred while registering the user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }


    @PostMapping("/pets")
    public String adoptPet(@RequestBody Pet pet) {
        // Here you need to add a method from PetService that handles pet adoption
        petService.adoptPet(pet);
        return "Pet adopted successfully";
    }

    @GetMapping("/pets")
    public List<Pet> listPets(@RequestParam String userId) {
        // Here you need to add a method from PetService that returns a list of pets for a specific user
        return petService.listPets(userId);
    }

    @PutMapping("/pets/{petId}")
    public String interactWithPet(@PathVariable String petId, @RequestBody Interaction interaction) {
        // Here you need to add a method from PetService that handles pet interactions
        petService.interactWithPet(petId, interaction);
        return "Pet interaction successful";
    }
    @PutMapping("/pets/{petId}/play")
    public String playWithPet(@PathVariable String petId) {
        petService.playWithPet(petId);
        return "Played with pet successfully";
    }

    @PutMapping("/pets/{petId}/feed")
    public String feedPet(@PathVariable String petId) {
        petService.feedPet(petId);
        return "Fed pet successfully";
    }

    @PutMapping("/pets/{petId}/groom")
    public String groomPet(@PathVariable String petId) {
        petService.groomPet(petId);
        return "Groomed pet successfully";
    }
}
