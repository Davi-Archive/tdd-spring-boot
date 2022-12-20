package io.davi.tdd2.repositories;

import io.davi.tdd2.entities.City;
import io.davi.tdd2.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
}
