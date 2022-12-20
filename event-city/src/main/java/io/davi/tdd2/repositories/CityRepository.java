package io.davi.tdd2.repositories;

import io.davi.tdd2.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Long> {
}
