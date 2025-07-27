package dev.guisandroni.Design_patterns_dio.repository;

import dev.guisandroni.Design_patterns_dio.model.PetShop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetShopRepository extends JpaRepository<PetShop,Long> {
}
