package com.pet.pet.service;

import com.pet.pet.controller.PetResponse;
import com.pet.pet.controller.model.PetRequest;
import com.pet.pet.model.Pet;
import com.pet.pet.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PetService {

    // Injecting PetRepository and UserService using constructor injection
    private final PetRepository petRepository;
    private final UserService userService;

    @Autowired
    public PetService(PetRepository petRepository, UserService userService) {
        this.petRepository = petRepository;
        this.userService = userService;
    }

    // Method to adopt a new pet. It creates a new Pet instance and saves it to the repository.
    public PetResponse adoptPet(PetRequest request) {
        // Check if the owner's email exists
        if (userService.userExists(request.getOwnerId())) {
            // Create a new pet instance with provided details
            Pet pet = new Pet(request.getOwnerId(), request.getName(), request.getType());
            // Save the pet to the repository and store the returned pet with id
            Pet savedPet = petRepository.save(pet);
            // Return the saved pet details as a PetResponse object
            return new PetResponse(savedPet.getOwnerId(), savedPet.getName(), savedPet.getType());
        } else {
            throw new IllegalArgumentException("User with provided email doesn't exist.");
        }
    }


    // Method to list all the pets of a user. It retrieves pets from the repository and maps them to PetResponse objects.
    public List<PetResponse> listPets(String userId) {
        // Retrieve the pets owned by the user
        List<Pet> pets = (List<Pet>) petRepository.findByOwnerId(userId);
        // Convert the list of Pet objects to PetResponse objects
        return pets.stream()
                .map(pet -> new PetResponse(pet.getOwnerId(), pet.getName(), pet.getType()))
                .collect(Collectors.toList());
    }

    // Method to update pet details. It retrieves the pet from the repository, updates the pet, and saves the updated pet back to the repository.
    public PetResponse updatePet(PetRequest request) {
        // Retrieve the pet by its id
        Optional<Pet> petOpt = petRepository.findById(request.getId());
        if (petOpt.isPresent()) {
            // Update the pet details
            Pet pet = petOpt.get();
            pet.setName(request.getName());
            pet.setType(request.getType());
            // Save the updated pet to the repository
            petRepository.save(pet);
            // Return the updated pet details as a PetResponse object
            return new PetResponse(pet.getOwnerId(), pet.getName(), pet.getType());
        }
        return null;
    }

    // Method to delete a pet. It retrieves the pet from the repository and deletes it.
    public boolean deletePet(String petId) {
        // Retrieve the pet by its id
        Optional<Pet> petOpt = petRepository.findById(petId);
        if (petOpt.isPresent()) {
            // Delete the pet from the repository
            petRepository.delete(petOpt.get());
            return true;
        }
        return false;
    }

    // Method to get a single pet by its id. It retrieves the pet from the repository and maps it to a PetResponse object.
    public PetResponse getPet(String petId) {
        // Retrieve the pet by its id
        Optional<Pet> petOpt = petRepository.findById(petId);
        // Convert the Pet object to a PetResponse object
        return petOpt.map(pet -> new PetResponse(pet.getOwnerId(), pet.getName(), pet.getType())).orElse(null);
    }

    // Method to play with a pet. It retrieves the pet from the repository, increases its happiness and health, possibly triggers a random event, and saves the updated pet back to the repository.
    public PetResponse playWithPet(String petId) {
        Optional<Pet> optionalPet = petRepository.findById(petId);
        if (optionalPet.isPresent()) {
            Pet pet = optionalPet.get();
            increaseHappiness(pet, 20);
            increaseHealth(pet, 10);
            petRepository.save(pet);
            return new PetResponse(pet.getOwnerId(), pet.getName(), pet.getType());
        }
        return null;
    }

    public PetResponse feedPet(String petId) {
        Optional<Pet> optionalPet = petRepository.findById(petId);
        if (optionalPet.isPresent()) {
            Pet pet = optionalPet.get();
            decreaseHunger(pet, 20);
            increaseHealth(pet, 10);
            petRepository.save(pet);
            return new PetResponse(pet.getOwnerId(), pet.getName(), pet.getType());
        }
        return null;
    }

    public PetResponse groomPet(String petId) {
        Optional<Pet> optionalPet = petRepository.findById(petId);
        if (optionalPet.isPresent()) {
            Pet pet = optionalPet.get();
            pet.setCleanliness(100);
            increaseHealth(pet, 10);
            petRepository.save(pet);
            return new PetResponse(pet.getOwnerId(), pet.getName(), pet.getType());
        }
        return null;
    }

    // Method to get pet's health. It retrieves the pet from the repository and returns its health.
    public Integer getPetHealth(String petId) {
        // Retrieve the pet by its id
        Optional<Pet> optionalPet = petRepository.findById(petId);
        if (optionalPet.isPresent()) {
            Pet pet = optionalPet.get();
            // Return the pet's health
            return pet.getHealth();
        }
        return null;
    }

    // Private helper methods to increase or decrease pet's stats
    private void increaseHealth(Pet pet, int amount) {
        int health = pet.getHealth();
        health += amount;
        if (health > 100) health = 100;
        pet.setHealth(health);
    }

    private void decreaseHunger(Pet pet, int amount) {
        int hunger = pet.getHunger();
        hunger -= amount;
        if (hunger < 0) hunger = 0;
        pet.setHunger(hunger);
    }

    private void increaseHappiness(Pet pet, int amount) {
        int happiness = pet.getHappiness();
        happiness += amount;
        if (happiness > 100) happiness = 100;
        pet.setHappiness(happiness);
    }

    // Private helper method to trigger a random event when playing with, feeding, or grooming the pet
    public String triggerRandomEvent(String petId) {
        Pet pet = petRepository.findPetById(petId);
        if (pet != null) {
            double randomEvent = Math.random();
            if (randomEvent < 0.1) {
                decreaseHealth(pet, 10);
                return "Pet had a minor accident! Its health is now " + pet.getHealth() + ".";
            } else if (randomEvent < 0.2) {
                increaseHappiness(pet, 10);
                return "Pet is extremely happy! Its happiness is now " + pet.getHappiness() + ".";
            }
        }
        return null;
    }


    // Method to decrease pet's health (due to a negative event)
    private void decreaseHealth(Pet pet, int amount) {
        int health = pet.getHealth();
        health -= amount;
        if (health < 0) health = 0;
        pet.setHealth(health);
    }

    public PetResponse adoptPet(String userId, String petId) {
        // Check if the owner's email exists
        if (userService.userExists(userId)) {
            // Retrieve the pet by its id
            Optional<Pet> petOpt = petRepository.findById(petId);
            if (petOpt.isPresent()) {
                // Create a new pet instance with provided details
                Pet pet = new Pet(userId, petOpt.get().getName(), petOpt.get().getType());
                // Save the pet to the repository and store the returned pet with id
                Pet savedPet = petRepository.save(pet);
                // Return the saved pet details as a PetResponse object
                return new PetResponse(savedPet.getOwnerId(), savedPet.getName(), savedPet.getType());
            }
        }
        return null;
    }
}
