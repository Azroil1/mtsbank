package ru.mtsbank.hw.service;

import ru.mtsbank.hw.dto.CreatureDto;

import java.util.List;

public interface CreatureService {
    List<CreatureDto> getCreatures();
    void createCreature(CreatureDto creature);
    void deleteCreature(Long creatureId);
}
