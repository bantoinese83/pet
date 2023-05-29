package com.pet.pet.repository;

import com.pet.pet.model.Pet;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface PetRepository extends CrudRepository<Pet, String> {
    Iterable<Pet> findByOwnerId(String ownerId);

    Pet findPetById(String petId);

}
