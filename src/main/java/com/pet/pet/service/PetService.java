package com.pet.pet.service;

import com.pet.pet.model.Interaction;
import com.pet.pet.model.Pet;
import com.pet.pet.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private final PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public void adoptPet(Pet pet) {
        petRepository.save(pet);
    }

    public List<Pet> findPetsByOwnerId(String ownerId) {
        return (List<Pet>) petRepository.findByOwnerId(ownerId);
    }

    public List<Pet> listPets(String userId) {
        return (List<Pet>) petRepository.findByOwnerId(userId);
    }

    public void interactWithPet(String petId, Interaction interaction) {
        Optional<Pet> optionalPet = petRepository.findById(petId);
        if(optionalPet.isPresent()) {
            Pet pet = optionalPet.get();
            petRepository.save(pet);
        } else {
            throw new PetNotFoundException("Pet with id: " + petId + " not found");
        }
    }

    public void deletePet(String petId) {
        petRepository.deleteById(petId);
    }

    public void deleteAllPets() {
        petRepository.deleteAll();
    }

    public void playWithPet(String petId) {
        Optional<Pet> optionalPet = petRepository.findById(petId);
        if (optionalPet.isPresent()) {
            Pet pet = optionalPet.get();
            int happiness = pet.getHappiness();
            happiness += 20;
            if (happiness > 100) happiness = 100;
            pet.setHappiness(happiness);
            petRepository.save(pet);
        }
    }

    public void feedPet(String petId) {
        Optional<Pet> optionalPet = petRepository.findById(petId);
        if (optionalPet.isPresent()) {
            Pet pet = optionalPet.get();
            int hunger = pet.getHunger();
            hunger -= 20;
            if (hunger < 0) hunger = 0;
            pet.setHunger(hunger);
            petRepository.save(pet);
        }
    }

    public void groomPet(String petId) {
        Optional<Pet> optionalPet = petRepository.findById(petId);
        if (optionalPet.isPresent()) {
            Pet pet = optionalPet.get();
            pet.setCleanliness(100);
            petRepository.save(pet);
        }
    }
}
