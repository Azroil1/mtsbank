package ru.mtsbank.hw.repository;

import org.springframework.data.repository.CrudRepository;
import ru.mtsbank.hw.entity.Habitat;

public interface HabitatRepository extends CrudRepository<Habitat, Long> {
}
