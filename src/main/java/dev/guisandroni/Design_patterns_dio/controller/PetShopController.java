package dev.guisandroni.Design_patterns_dio.controller;

import dev.guisandroni.Design_patterns_dio.model.PetShop;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/animal")
public class PetShopController {

    @PostMapping("animals")
    public Animal addAnimal(@RequestBody Animal animal){
        return 
    }
}
