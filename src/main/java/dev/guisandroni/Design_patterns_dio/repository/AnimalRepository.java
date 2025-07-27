package dev.guisandroni.Design_patterns_dio.repository;

import dev.guisandroni.Design_patterns_dio.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal,Long> {
}

