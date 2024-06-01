package ru.mtsbank.hw.mapperentitytodto;

import org.springframework.stereotype.Component;
import ru.mtsbank.hw.dto.BreedDto;
import ru.mtsbank.hw.dto.CreatureDto;
import ru.mtsbank.hw.entity.Breed;
import ru.mtsbank.hw.entity.Creature;
import ru.mtsbank.hw.repository.BreedRepository;

import java.util.stream.Collectors;

@Component
public class CreatureMapper {


    private static BreedRepository repository;

    public CreatureMapper(BreedRepository repository) {
        this.repository = repository;
    }

    public static CreatureDto toDto(Creature creature) {
        if (creature == null) {
            return null;
        }
        return new CreatureDto(
                creature.getId(),
                creature.getName(),
                creature.getAge(),
                creature.getBirthDate(),
                toBreedDto(creature.getBreed())
        );
    }

    public static BreedDto toBreedDto(Breed breed) {
        if (breed == null) {
            return null;
        }
        return new BreedDto(
                breed.getIdBreed(),
                breed.getType(),
                breed.getBreedCreatures().stream()
                        .map(CreatureMapper::toSimpleDto)
                        .collect(Collectors.toList())
        );
    }

    private static CreatureDto toSimpleDto(Creature creature) {
        if (creature == null) {
            return null;
        }
        return new CreatureDto(
                creature.getId(),
                creature.getName(),
                creature.getAge(),
                creature.getBirthDate(),
                null
        );
    }

    public static Creature toEntity(CreatureDto creatureDto) {
        if (creatureDto == null) {
            return null;
        }
        return new Creature(
                creatureDto.getId(),
                creatureDto.getName(),
                creatureDto.getAge(),
                creatureDto.getBirthDate(),
                toBreed(creatureDto.getBreed())
        );
    }

    public static Breed toBreed(BreedDto breedDto) {
        if (breedDto == null) {
            return null;
        }
        System.out.println(breedDto);
        Breed breed = repository.findByType(breedDto.getType());
        if(breed == null){
            breed = new Breed();
            breed.setType(breedDto.getType());
            repository.save(breed);
        }
        return breed;
    }

    private static Creature toSimpleEntity(CreatureDto creatureDto) {
        if (creatureDto == null) {
            return null;
        }
        return new Creature(
                creatureDto.getId(),
                creatureDto.getName(),
                creatureDto.getAge(),
                creatureDto.getBirthDate(),
                null
        );
    }
}
