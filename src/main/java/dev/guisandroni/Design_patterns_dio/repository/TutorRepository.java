package dev.guisandroni.Design_patterns_dio.repository;

import dev.guisandroni.Design_patterns_dio.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<Tutor,Long> {
}
