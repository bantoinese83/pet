package com.pet.pet.controller;

import com.pet.pet.model.Interaction;
import com.pet.pet.model.Pet;
import com.pet.pet.model.User;
import com.pet.pet.service.PetService;
import com.pet.pet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String registerUser(@RequestBody User user) {
        // Here you need to add a method from UserService that handles user registration
        userService.registerUser(user);
        return "User registered successfully";
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
}
