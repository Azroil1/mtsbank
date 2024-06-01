package ru.mtsbank.hw.service;

import org.springframework.stereotype.Service;
import ru.mtsbank.hw.annatation.PublicLogger;
import ru.mtsbank.hw.dto.CreatureDto;
import ru.mtsbank.hw.entity.Breed;
import ru.mtsbank.hw.entity.Creature;
import ru.mtsbank.hw.mapperentitytodto.CreatureMapper;
import ru.mtsbank.hw.repository.BreedRepository;
import ru.mtsbank.hw.repository.CreatureRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreatureServiceImpl implements CreatureService{

    CreatureRepository creatureRepository;
    BreedRepository breedRepository;
    public CreatureServiceImpl(CreatureRepository creatureRepository, BreedRepository breedRepository) {
        this.creatureRepository = creatureRepository;
        this.breedRepository = breedRepository;
    }

    @Override
    public List<CreatureDto> getCreatures() {
        return creatureRepository.findAll().stream().map(CreatureMapper::toDto).collect(Collectors.toList());
    }

    @PublicLogger("createCreature")
    @Override
    public void createCreature(CreatureDto creatureDto) {
        Creature creature = CreatureMapper.toEntity(creatureDto);
        Breed breed = breedRepository.findByType(creatureDto.getBreed().getType());
        if(breed != null){
            creature.setBreed(breed);
        }
        creatureRepository.save(creature);
    }

    @PublicLogger(value = "Удаление животного", entering = true, exiting = true)
    @Override
    public void deleteCreature(Long creatureId) {
        creatureRepository.deleteById(creatureId);
    }
}
