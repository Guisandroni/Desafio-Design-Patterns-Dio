package dev.guisandroni.Design_patterns_dio.service;

import dev.guisandroni.Design_patterns_dio.model.PetShop;
import dev.guisandroni.Design_patterns_dio.repository.PetShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PetShopService {

    @Autowired
    private PetShopRepository petShopRepository;


    public List<PetShop> findAll(){
        return petShopRepository.findAll();
    }

    public PetShop save(PetShop petshop) {

        return petShopRepository.save(petshop);
    }

    public PetShop update(Long id, PetShop updatedPetshop) {
        return petShopRepository.findById(id)
                .map(petshop -> {
                    petshop.setName(updatedPetshop.getName());
                    petshop.setServices(updatedPetshop.getServices());
                    petshop.setPrice(updatedPetshop.getPrice());
                    return petShopRepository.save(petshop);
                })
                .orElseThrow(() -> new RuntimeException("PetShop não encontrado com ID: " + id));
    }

    public void deleteById(Long id) {
        petShopRepository.deleteById(id);
    }
}
