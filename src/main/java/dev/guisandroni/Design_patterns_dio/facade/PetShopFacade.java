package dev.guisandroni.Design_patterns_dio.facade;

import dev.guisandroni.Design_patterns_dio.repository.AnimalRepository;
import dev.guisandroni.Design_patterns_dio.repository.PetShopRepository;
import dev.guisandroni.Design_patterns_dio.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
public class PetShopFacade {
    @Autowired
    private AnimalService animalService;
    @Autowired
    private TutorService tutorService;
    @Autowired
    private PetShopService petShopService;



    public List<Tutor> findAllTutors(){
        return tutorService.fildAll();
    }



}
