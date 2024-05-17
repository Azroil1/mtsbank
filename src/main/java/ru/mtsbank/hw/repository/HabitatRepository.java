package ru.mtsbank.hw.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mtsbank.hw.entity.Habitat;
@Repository
public interface HabitatRepository extends CrudRepository<Habitat, Long> {
}
