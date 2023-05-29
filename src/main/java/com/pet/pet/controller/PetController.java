package com.pet.pet.controller;

import com.pet.pet.controller.model.PetRequest;
import com.pet.pet.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080") // Adjust the origin as needed
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping("/pets")
    public ResponseEntity<PetResponse> adoptPet(@RequestBody PetRequest petRequest) {
        PetResponse response = petService.adoptPet(petRequest);
        return response != null ? ResponseEntity.status(HttpStatus.CREATED).body(response)
                : ResponseEntity.badRequest().build();
    }

    @GetMapping("/pets")
    public ResponseEntity<List<PetResponse>> listPets(@RequestParam String userId) {
        List<PetResponse> response = petService.listPets(userId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/pets/{petId}")
    public ResponseEntity<PetResponse> updatePet(@RequestBody PetRequest petRequest, @PathVariable String petId) {
        PetResponse response = petService.updatePet(petRequest);
        return response != null ? ResponseEntity.ok(response)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/pets/{petId}")
    public ResponseEntity<Void> deletePet(@PathVariable String petId) {
        petService.deletePet(petId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/pets/{petId}")
    public ResponseEntity<PetResponse> getPet(@PathVariable String petId) {
        PetResponse response = petService.getPet(petId);
        return response != null ? ResponseEntity.ok(response)
                : ResponseEntity.notFound().build();
    }

    @PostMapping("/pets/{petId}/play")
    public ResponseEntity<PetResponse> playWithPet(@PathVariable String petId) {
        PetResponse response = petService.playWithPet(petId);
        return response != null ? ResponseEntity.ok(response)
                : ResponseEntity.notFound().build();
    }

    @PostMapping("/pets/{petId}/feed")
    public ResponseEntity<PetResponse> feedPet(@PathVariable String petId) {
        PetResponse response = petService.feedPet(petId);
        return response != null ? ResponseEntity.ok(response)
                : ResponseEntity.notFound().build();
    }

    @PostMapping("/pets/{petId}/groom")
    public ResponseEntity<PetResponse> groomPet(@PathVariable String petId) {
        PetResponse response = petService.groomPet(petId);
        return response != null ? ResponseEntity.ok(response)
                : ResponseEntity.notFound().build();
    }
    @GetMapping("/pets/{petId}/randomEvent")
    public ResponseEntity<String> triggerRandomEventForPet(@PathVariable String petId) {
        String eventResult = petService.triggerRandomEvent(petId);
        return eventResult != null ? ResponseEntity.ok(eventResult)
                : ResponseEntity.notFound().build();
    }


    @GetMapping("/pets/{petId}/health")
    public ResponseEntity<Integer> getPetHealth(@PathVariable String petId) {
        Integer petHealth = petService.getPetHealth(petId);
        return petHealth != null ? ResponseEntity.ok(petHealth)
                : ResponseEntity.notFound().build();
    }

}
