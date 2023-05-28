package com.pet.pet.service;

import com.pet.pet.model.Interaction;
import com.pet.pet.model.Pet;
import com.pet.pet.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // This annotation indicates that the class provides some business functionalities.
public class PetService {

    private final PetRepository petRepository; // Declare a repository that will interact with the database.

    @Autowired // This annotation allows Spring to resolve and inject collaborating beans into this class.
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository; // Assign the injected repository to the class-level one.
    }

    // Method to save a pet to the database.
    public void adoptPet(Pet pet) {
        petRepository.save(pet);
    }

    // Method to find pets by their owner's ID.
    public List<Pet> findPetsByOwnerId(String ownerId) {
        return (List<Pet>) petRepository.findByOwnerId(ownerId);
    }

    // Method to list pets owned by a specific user.
    public List<Pet> listPets(String userId) {
        return (List<Pet>) petRepository.findByOwnerId(userId);
    }

    // Method to handle interactions with a pet.
    public void interactWithPet(String petId, Interaction interaction) {
        Optional<Pet> optionalPet = petRepository.findById(petId); // Get the pet by its ID.
        if(optionalPet.isPresent()) { // Check if a pet with the given ID exists.
            Pet pet = optionalPet.get(); // If it exists, get it.
            petRepository.save(pet); // Save the pet.
        } else { // If a pet with the given ID does not exist, throw an exception.
            throw new PetNotFoundException("Pet with id: " + petId + " not found");
        }
    }

    // Method to delete a pet from the database by its ID.
    public void deletePet(String petId) {
        petRepository.deleteById(petId);
    }

    // Method to delete all pets from the database.
    public void deleteAllPets() {
        petRepository.deleteAll();
    }

    // Method to play with a pet and increase its happiness.
    //... other code
    public String playWithPet(String petId) {
        Optional<Pet> optionalPet = petRepository.findById(petId);
        if (optionalPet.isPresent()) {
            Pet pet = optionalPet.get();
            int happiness = pet.getHappiness();
            happiness += 20;
            if (happiness > 100) happiness = 100;
            pet.setHappiness(happiness);

            int health = pet.getHealth();
            health += 10; // Increase health when the pet plays.
            if (health > 100) health = 100;
            pet.setHealth(health);

            // Random event
            double randomEvent = Math.random();
            if (randomEvent < 0.1) {
                health -= 10;
                pet.setHealth(health);
                return "Pet stumbled while playing! Its health is now " + pet.getHealth() + ".";
            } else if (randomEvent < 0.2) {
                happiness += 10;
                pet.setHappiness(happiness);
                return "Pet had a lot of fun playing! Its happiness is now " + pet.getHappiness() + ".";
            }

            petRepository.save(pet);
            return "Pet is very happy! Its health is now " + pet.getHealth() + ".";
        }
        return "Pet not found.";
    }




    public String feedPet(String petId) {
        Optional<Pet> optionalPet = petRepository.findById(petId);
        if (optionalPet.isPresent()) {
            Pet pet = optionalPet.get();
            int hunger = pet.getHunger();
            hunger -= 20;
            if (hunger < 0) hunger = 0;
            pet.setHunger(hunger);

            int health = pet.getHealth();
            health += 10; // Increase health when the pet is fed.
            if (health > 100) health = 100;
            pet.setHealth(health);

            // Random event
            double randomEvent = Math.random();
            if (randomEvent < 0.1) {
                health -= 10;
                pet.setHealth(health);
                return "Pet ate too fast and feels a bit sick! Its health is now " + pet.getHealth() + ".";
            } else if (randomEvent < 0.2) {
                int happiness = pet.getHappiness();
                happiness += 10;
                pet.setHappiness(happiness);
                return "Pet really loved the food! Its happiness is now " + pet.getHappiness() + ".";
            }

            petRepository.save(pet);
            return "Pet is now well fed! Its health is now " + pet.getHealth() + ".";
        }
        return "Pet not found.";
    }

    public String groomPet(String petId) {
        Optional<Pet> optionalPet = petRepository.findById(petId);
        if (optionalPet.isPresent()) {
            Pet pet = optionalPet.get();
            pet.setCleanliness(100);

            int health = pet.getHealth();
            health += 10; // Increase health when the pet is groomed.
            if (health > 100) health = 100;
            pet.setHealth(health);

            // Random event
            double randomEvent = Math.random();
            if (randomEvent < 0.1) {
                health -= 10;
                pet.setHealth(health);
                return "Pet didn't enjoy the grooming session and got stressed! Its health is now " + pet.getHealth() + ".";
            } else if (randomEvent < 0.2) {
                int happiness = pet.getHappiness();
                happiness += 10;
                pet.setHappiness(happiness);
                return "Pet feels refreshed after the grooming session! Its happiness is now " + pet.getHappiness() + ".";
            }

            petRepository.save(pet);
            return "Pet is now squeaky clean! Its health is now " + pet.getHealth() + ".";
        }
        return "Pet not found.";
    }




    public Integer getPetHealth(String petId) {
        Optional<Pet> optionalPet = petRepository.findById(petId);
        if (optionalPet.isPresent()) {
            Pet pet = optionalPet.get();
            return pet.getHealth();
        }
        return null;
    }
}
