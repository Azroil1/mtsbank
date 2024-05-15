package ru.mtsbank.hw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mtsbank.hw.entity.Breed;

public interface BreedRepository extends JpaRepository<Breed,Long> {
}
