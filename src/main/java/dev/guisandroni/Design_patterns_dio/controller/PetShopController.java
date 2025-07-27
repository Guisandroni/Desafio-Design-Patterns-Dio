package dev.guisandroni.Design_patterns_dio.controller;

import dev.guisandroni.Design_patterns_dio.facade.PetShopFacade;
import dev.guisandroni.Design_patterns_dio.model.Animal;
import dev.guisandroni.Design_patterns_dio.model.PetShop;
import dev.guisandroni.Design_patterns_dio.model.Tutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/api/petshop")
public class PetShopController {



    @Autowired
    private PetShopFacade petShopFacade;

    // --- Endpoints para Tutores ---
    @GetMapping("/tutores")
    public ResponseEntity<List<Tutor>> getAllTutores() {
        return ResponseEntity.ok(petShopFacade.findAllTutores());
    }

    @GetMapping("/tutores/{id}")
    public ResponseEntity<Tutor> getTutorById(@PathVariable Long id) {
        return petShopFacade.findTutorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/tutores")
    public ResponseEntity<Tutor> createTutor(@RequestBody Tutor tutor) {
        Tutor savedTutor = petShopFacade.createTutor(tutor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTutor);
    }

    @PutMapping("/tutores/{id}")
    public ResponseEntity<Tutor> updateTutor(@PathVariable Long id, @RequestBody Tutor tutor) {
        try {
            Tutor updatedTutor = petShopFacade.updateTutor(id, tutor);
            return ResponseEntity.ok(updatedTutor);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/tutores/{id}")
    public ResponseEntity<Void> deleteTutor(@PathVariable Long id) {
        petShopFacade.deleteTutor(id);
        return ResponseEntity.noContent().build();
    }

    // --- Endpoints para Animais ---
    @GetMapping("/animais")
    public ResponseEntity<List<Animal>> getAllAnimais() {
        return ResponseEntity.ok(petShopFacade.findAllAnimais());
    }

    @GetMapping("/animais/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable Long id) {
        return petShopFacade.findAnimalById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/animais/tutor/{tutorId}")
    public ResponseEntity<Animal> createAnimal(@PathVariable Long tutorId, @RequestBody Animal animal) {
        try {
            Animal savedAnimal = petShopFacade.createAnimalForTutor(tutorId, animal);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedAnimal);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null); // Melhorar tratamento de erro
        }
    }

    @PutMapping("/animais/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable Long id, @RequestBody Animal animal) {
        try {
            Animal updatedAnimal = petShopFacade.updateAnimal(id, animal);
            return ResponseEntity.ok(updatedAnimal);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/animais/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Long id) {
        petShopFacade.deleteAnimal(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/tutores/{tutorId}/animais")
    public ResponseEntity<List<Animal>> getAnimalsByTutorId(@PathVariable Long tutorId) {
        List<Animal> animals = petShopFacade.findAnimalsByTutor(tutorId);
        return ResponseEntity.ok(animals);
    }

    // --- Endpoints para Petshops (se houver, exemplo) ---
    @GetMapping("/petshops")
    public ResponseEntity<List<PetShop>> getAllPetshops() {
        return ResponseEntity.ok(petShopFacade.findAllPetshops());
    }

    @PostMapping("/petshops")
    public ResponseEntity<PetShop> createPetshop(@RequestBody PetShop petshop) {
        PetShop savedPetshop = petShopFacade.createPetshop(petshop);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPetshop);
    }
}
