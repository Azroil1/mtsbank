package ru.mtsbank.hw.service;

import ru.mtsbank.hw.entity.Creature;

import java.util.List;

public interface CreatureService {
    List<Creature> getCreatures();
    void createCreature(Creature creature);
    void deleteCreature(Long creatureId);
}
