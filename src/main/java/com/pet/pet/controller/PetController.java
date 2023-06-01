package com.pet.pet.controller;

import com.pet.pet.controller.model.PetRequest;
import com.pet.pet.model.Pet;
import com.pet.pet.repository.PetRepository;
import com.pet.pet.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080") // Adjust the origin as needed
public class PetController {

    private final PetService petService;
    private final PetRepository petRepository;

    public PetController(PetService petService, PetRepository petRepository) {
        this.petService = petService;
        this.petRepository = petRepository;
    }

    @PostMapping("/pets/{petId}/adopt")
    public ResponseEntity<?> adoptPet(@PathVariable String petId, @RequestParam String userId) {
        try {
            PetResponse response = petService.adoptPet(petId, userId);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/pets")
    public ResponseEntity<List<PetResponse>> listPets(@RequestParam String userId) {
        List<PetResponse> response = petService.listPets(userId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/pets/{petId}")
    public ResponseEntity<PetResponse> updatePet(@RequestBody PetRequest petRequest, @PathVariable String petId) {
        PetResponse response = petService.updatePet(petRequest);
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/pets/{petId}")
    public ResponseEntity<Void> deletePet(@PathVariable String petId) {
        boolean deleted = petService.deletePet(petId);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/pets/{petId}")
    public ResponseEntity<PetResponse> getPet(@PathVariable String petId) {
        PetResponse response = petService.getPet(petId);
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @PostMapping("/pets/{petId}/play")
    public ResponseEntity<PetStatusResponse> playPet(@PathVariable String petId) {
        PetStatusResponse response = petService.playWithPet(petId);
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @PostMapping("/pets/{petId}/feed")
    public ResponseEntity<PetStatusResponse> feedPet(@PathVariable String petId) {
        PetStatusResponse response = petService.feedPet(petId);
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @PostMapping("/pets/{petId}/groom")
    public ResponseEntity<PetStatusResponse> groomPet(@PathVariable String petId) {
        PetStatusResponse response = petService.groomPet(petId);
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @GetMapping("/pets/{petId}/randomEvent")
    public ResponseEntity<String> triggerRandomEventForPet(@PathVariable String petId) {
        String eventResult = petService.triggerRandomEventForPet(petId);
        return eventResult != null ? ResponseEntity.ok(eventResult) : ResponseEntity.notFound().build();
    }

    @GetMapping("/pets/{petId}/health")
    public ResponseEntity<Integer> getPetHealth(@PathVariable String petId) {
        Integer petHealth = petService.getPetHealth(petId);
        return petHealth != null ? ResponseEntity.ok(petHealth) : ResponseEntity.notFound().build();
    }

    @GetMapping("/pets/{petId}/status")
    public ResponseEntity<PetStatusResponse> getPetStatus(@PathVariable String petId) {
        Optional<Pet> optionalPet = petRepository.findById(petId);
        return optionalPet.map(pet -> ResponseEntity.ok(petService.createPetStatusResponse(pet)))
                .orElse(ResponseEntity.notFound().build());
    }
}
