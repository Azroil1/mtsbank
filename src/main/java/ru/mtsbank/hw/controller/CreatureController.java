package ru.mtsbank.hw.controller;

import org.springframework.web.bind.annotation.*;
import ru.mtsbank.hw.entity.Breed;
import ru.mtsbank.hw.entity.Creature;
import ru.mtsbank.hw.repository.BreedRepository;
import ru.mtsbank.hw.repository.CreatureRepository;

@RestController
@RequestMapping("/creature/api")
public class CreatureController {
    private CreatureRepository creatureRepository;
    private BreedRepository breedRepository;

    public CreatureController(CreatureRepository creatureRepository, BreedRepository breedRepository) {
        this.breedRepository = breedRepository;
        this.creatureRepository = creatureRepository;
    }

    @PostMapping("/add")
    public String addCreature(@RequestBody Creature creature){
        Breed  breed = breedRepository.findByType(creature.getBreed().getType());
        if(breed == null){
            breed = creature.getBreed();
        }else{
            creature.setBreed(breed);
        }
        creatureRepository.save(creature);
        return "SUCCESS";
    }


    @DeleteMapping("/delete")
    public String deleteCreature(@RequestParam(name = "id") long id){
        creatureRepository.deleteById(id);
        return "SUCCESS DELETE";
    }
}
