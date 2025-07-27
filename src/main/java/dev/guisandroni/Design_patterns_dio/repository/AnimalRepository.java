package dev.guisandroni.Design_patterns_dio.repository;

import dev.guisandroni.Design_patterns_dio.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal,Long> {
    List<Animal> findByTutorId(Long tutorId);
}

