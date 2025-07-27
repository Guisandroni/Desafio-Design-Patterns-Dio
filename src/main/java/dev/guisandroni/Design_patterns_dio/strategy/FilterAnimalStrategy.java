package dev.guisandroni.Design_patterns_dio.strategy;

import dev.guisandroni.Design_patterns_dio.model.Animal;

import java.util.List;

public class FilterAnimalStrategy {

  public  List<Animal> filter(List<Animal> animals, String value) {
    return animals;
  }
}
