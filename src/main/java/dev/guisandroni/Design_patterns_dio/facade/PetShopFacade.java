package dev.guisandroni.Design_patterns_dio.facade;

import dev.guisandroni.Design_patterns_dio.model.Animal;
import dev.guisandroni.Design_patterns_dio.model.PetShop;
import dev.guisandroni.Design_patterns_dio.model.Tutor;
import dev.guisandroni.Design_patterns_dio.repository.AnimalRepository;
import dev.guisandroni.Design_patterns_dio.repository.PetShopRepository;
import dev.guisandroni.Design_patterns_dio.repository.TutorRepository;
import dev.guisandroni.Design_patterns_dio.service.AnimalService;
import dev.guisandroni.Design_patterns_dio.service.PetShopService;
import dev.guisandroni.Design_patterns_dio.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Component
public class PetShopFacade {
    @Autowired
    private AnimalService animalService;
    @Autowired
    private TutorService tutorService;
    @Autowired
    private PetShopService petShopService;



    public List<Tutor> findAllTutors(){
        return tutorService.findAll();
    }



    public List<Tutor> findAllTutores() {
        return tutorService.findAll();
    }

    public Optional<Tutor> findTutorById(Long id) {
        return tutorService.findById(id);
    }

    public Tutor createTutor(Tutor tutor) {
        return tutorService.save(tutor);
    }

    public Tutor updateTutor(Long id, Tutor tutor) {
        return tutorService.update(id, tutor);
    }

    public void deleteTutor(Long id) {
        tutorService.deleteById(id);
    }

    public List<Animal> findAllAnimais() {
        return animalService.findAll();
    }

    public Optional<Animal> findAnimalById(Long id) {
        return animalService.findById(id);
    }

    public Animal createAnimalForTutor(Long tutorId, Animal animal) {
        // A lógica de associação com o tutor já estaria no AnimalService
        return animalService.save(tutorId, animal);
    }

    public Animal updateAnimal(Long id, Animal animal) {
        return animalService.update(id, animal);
    }

    public void deleteAnimal(Long id) {
        animalService.deleteById(id);
    }

    public List<Animal> findAnimalsByTutor(Long tutorId) {
        return animalService.findAnimalsByTutorId(tutorId);
    }

    public List<PetShop> findAllPetshops() {
        return petShopService.findAll();
    }

    public PetShop createPetshop(PetShop petshop) {
        return petShopService.save(petshop);
    }

}
