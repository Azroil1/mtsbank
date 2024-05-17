package ru.mtsbank.hw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mtsbank.hw.entity.Breed;

@Repository
public interface BreedRepository extends JpaRepository<Breed,Long> {
    Breed getBreedByType(String type);
    Breed findByType(String type);
}
