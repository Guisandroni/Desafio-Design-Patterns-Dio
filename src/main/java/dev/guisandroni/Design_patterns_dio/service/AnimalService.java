package dev.guisandroni.Design_patterns_dio.service;


import dev.guisandroni.Design_patterns_dio.model.Animal;
import dev.guisandroni.Design_patterns_dio.model.Tutor;
import dev.guisandroni.Design_patterns_dio.repository.AnimalRepository;
import dev.guisandroni.Design_patterns_dio.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {


    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private TutorRepository tutorRepository;

    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    public Optional<Animal> findById(Long id) {
        return animalRepository.findById(id);
    }


    public Animal save(Long tutorId, Animal animal) {
        Optional<Tutor> tutorOptional = tutorRepository.findById(tutorId);
        if (tutorOptional.isPresent()) {
            Tutor tutor = tutorOptional.get();
            animal.setTutor(tutor.getId());

            return animalRepository.save(animal);
        } else {
            throw new RuntimeException("Tutor não encontrado com ID: " + tutorId);
        }
    }

    public Animal update(Long id, Animal updatedAnimal) {
        return animalRepository.findById(id)
                .map(animal -> {
                    animal.setName(updatedAnimal.getName());
                    animal.setRace(updatedAnimal.getRace());
                    animal.setAge(updatedAnimal.getAge());
                    animal.setGender(updatedAnimal.getGender());
                    animal.setWeight(updatedAnimal.getWeight());

                    return animalRepository.save(animal);
                })
                .orElseThrow(() -> new RuntimeException("Animal não encontrado com ID: " + id));
    }

    public void deleteById(Long id) {
        animalRepository.deleteById(id);
    }

    public List<Animal> findAnimalsByTutorId(Long tutorId) {

        return animalRepository.findByTutorId(tutorId);
    }
}
