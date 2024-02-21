package ru.mtsbank.hw.animalservice;

import org.springframework.beans.factory.annotation.Autowired;
import ru.mtsbank.hw.animal.AbstractAnimal;
import ru.mtsbank.hw.animal.fish.Fish;
import ru.mtsbank.hw.animal.herbivores.Herbivores;
import ru.mtsbank.hw.animal.pet.Pet;
import ru.mtsbank.hw.config.AnimalProperties;

import java.util.Random;



public class CreateAnimalServiceImpl implements CreateAnimalService {

    protected AnimalTypes types;

    @Autowired
    CreateAnimal createAnimal;

    AnimalProperties properties;

    public CreateAnimalServiceImpl(AnimalProperties properties) {
        this.properties = properties;
    }

    @Override
    public AbstractAnimal createAnimal() {
        AbstractAnimal abstractAnimals;

            abstractAnimals = createAnimal.create(AnimalTypes.values()
                    [new Random().nextInt(AnimalTypes.values().length)]);
            if(abstractAnimals instanceof Fish){
                abstractAnimals.setName(properties.getFishNames());
            } else if (abstractAnimals instanceof Herbivores) {
                abstractAnimals.setName(properties.getHerbivoresNames());
            } else if (abstractAnimals instanceof Pet) {
                abstractAnimals.setName(properties.getPetNames());
            } else {
                abstractAnimals.setName(properties.getPredatorNames());
            }
        return abstractAnimals;
    }

    public AnimalTypes getTypes() {
        return types;
    }

    public void setTypes(AnimalTypes types) {
        this.types = types;
    }
}
