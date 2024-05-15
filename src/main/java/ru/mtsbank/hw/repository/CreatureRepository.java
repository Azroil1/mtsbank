package ru.mtsbank.hw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mtsbank.hw.entity.Creature;
@Repository
public interface CreatureRepository extends JpaRepository<Creature, Long> {
}
