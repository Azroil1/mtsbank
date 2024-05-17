package ru.mtsbank.hw.service;

import org.springframework.stereotype.Service;
import ru.mtsbank.hw.entity.Breed;
import ru.mtsbank.hw.entity.Creature;
import ru.mtsbank.hw.repository.BreedRepository;
import ru.mtsbank.hw.repository.CreatureRepository;

import java.util.List;
@Service
public class CreatureServiceImpl implements CreatureService{

    CreatureRepository creatureRepository;
    BreedRepository breedRepository;
    public CreatureServiceImpl(CreatureRepository creatureRepository, BreedRepository breedRepository) {
        this.creatureRepository = creatureRepository;
        this.breedRepository = breedRepository;
    }

    @Override
    public List<Creature> getCreatures() {
        return creatureRepository.findAll();
    }

    @Override
    public void createCreature(Creature creature) {
        Breed breed = breedRepository.findByType(creature.getBreed().getType());
        if(breed != null){
            creature.setBreed(breed);
        }
        creatureRepository.save(creature);
    }

    @Override
    public void deleteCreature(Long creatureId) {
        creatureRepository.deleteById(creatureId);
    }
}
