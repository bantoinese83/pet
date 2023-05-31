package com.pet.pet.service;

import com.pet.pet.controller.PetResponse;
import com.pet.pet.controller.PetStatusResponse;
import com.pet.pet.controller.model.PetRequest;
import com.pet.pet.model.Pet;
import com.pet.pet.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
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
    // Method to adopt a new pet. It creates a new Pet instance and saves it to the repository.
    public PetResponse adoptPet(String petId, String userId) {
        // Check if the owner's email exists
        if (userService.userExists(userId)) {
            // Retrieve the pet by its id
            Optional<Pet> petOpt = petRepository.findById(petId);
            if (petOpt.isPresent()) {
                // Create a new pet instance with provided details
                Pet pet = petOpt.get();
                pet.setOwnerId(userId);
                // Save the pet to the repository and store the returned pet with id
                Pet savedPet = petRepository.save(pet);
                // Return the saved pet details as a PetResponse object
                return new PetResponse(savedPet.getOwnerId(), savedPet.getName(), savedPet.getType());
            } else {
                throw new IllegalArgumentException("Pet with provided ID doesn't exist.");
            }
        } else {
            throw new IllegalArgumentException("User with provided ID doesn't exist.");
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
    public PetStatusResponse playWithPet(String petId) {
        Optional<Pet> optionalPet = petRepository.findById(petId);
        if (optionalPet.isPresent()) {
            Pet pet = optionalPet.get();
            increaseHappiness(pet, 20);
            increaseHealth(pet);
            triggerRandomEvent(pet);
            petRepository.save(pet);
            return createPetStatusResponse(pet);
        }
        return null;
    }

    public PetStatusResponse feedPet(String petId) {
        Optional<Pet> optionalPet = petRepository.findById(petId);
        if (optionalPet.isPresent()) {
            Pet pet = optionalPet.get();
            decreaseHunger(pet);
            increaseHealth(pet);
            triggerRandomEvent(pet);
            petRepository.save(pet);
            return createPetStatusResponse(pet);
        }
        return null;
    }

    public PetStatusResponse groomPet(String petId) {
        Optional<Pet> optionalPet = petRepository.findById(petId);
        if (optionalPet.isPresent()) {
            Pet pet = optionalPet.get();
            pet.setCleanliness(100);
            increaseHealth(pet);
            triggerRandomEvent(pet);
            petRepository.save(pet);
            return createPetStatusResponse(pet);
        }
        return null;
    }

    // Private helper method to create a PetStatusResponse object from a Pet
    public PetStatusResponse createPetStatusResponse(Pet pet) {
        return new PetStatusResponse(pet.getOwnerId(), pet.getName(), pet.getType(), pet.getHealth(), pet.getHunger(), pet.getHappiness());
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
    private void increaseHealth(Pet pet) {
        int health = pet.getHealth();
        health += 10;
        if (health > 100) health = 100;
        pet.setHealth(health);
    }

    private void decreaseHunger(Pet pet) {
        int hunger = pet.getHunger();
        hunger -= 20;
        if (hunger < 0) hunger = 0;
        pet.setHunger(hunger);
    }

    private void increaseHappiness(Pet pet, int amount) {
        int happiness = pet.getHappiness();
        happiness += amount;
        if (happiness > 100) happiness = 100;
        pet.setHappiness(happiness);
    }

    public String triggerRandomEventForPet(String petId) {
        Optional<Pet> petOpt = petRepository.findById(petId);
        if (petOpt.isPresent()) {
            Pet pet = petOpt.get();
            return triggerRandomEvent(pet);
        }
        return null;
    }

    private String triggerRandomEvent(Pet pet) {
        Random random = new Random();
        double randomEvent = random.nextDouble();
        if (randomEvent < 0.1) {
            decreaseHealth(pet);
            return "Oh no! Your pet had a minor accident. Its health is now " + pet.getHealth() + ".";
        } else if (randomEvent < 0.2) {
            increaseHappiness(pet, 10);
            return "Yay! Your pet is extremely happy. Its happiness is now " + pet.getHappiness() + ".";
        }
        return null;
    }



    // Method to decrease pet's health (due to a negative event)
    private void decreaseHealth(Pet pet) {
        int health = pet.getHealth();
        health -= 10;
        if (health < 0) health = 0;
        pet.setHealth(health);
    }


    public PetStatusResponse getPetStatus(String petId) {
        // Retrieve the pet by its id
        Optional<Pet> petOpt = petRepository.findById(petId);
        if (petOpt.isPresent()) {
            Pet pet = petOpt.get();
            // Retrieve the pet's status (health, hunger, and happiness)
            int health = pet.getHealth();
            int hunger = pet.getHunger();
            int happiness = pet.getHappiness();
            // Return the pet's status as a PetStatusResponse object
            return new PetStatusResponse(pet.getOwnerId(), pet.getName(), pet.getType(), health, hunger, happiness);
        }
        return null;
    }

}
