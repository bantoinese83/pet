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
        // Business logic to validate pet data can be added here
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
            // apply the interaction to the pet
            petRepository.save(pet);
        } else {
            throw new PetNotFoundException("Pet with id: " + petId + " not found");
        }
    }

    // Additional methods for pet management can be added here

    public void deletePet(String petId) {
        petRepository.deleteById(petId);
    }

    public void deleteAllPets() {
        petRepository.deleteAll();
    }


}
