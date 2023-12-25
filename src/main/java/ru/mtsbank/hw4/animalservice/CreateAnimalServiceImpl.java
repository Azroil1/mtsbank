package ru.mtsbank.hw4.animalservice;

import ru.mtsbank.hw4.animal.AbstractAnimal;

import java.util.Random;

public class CreateAnimalServiceImpl implements CreateAnimalService {
    @Override
    public AbstractAnimal[] createAnimal() {
        return CreateAnimalService.super.createAnimal();
    }
    public AbstractAnimal[] createAnimal(int num) {
        CreateAnimal createAnimal = new CreateAnimal();
        AbstractAnimal[] abstractAnimals = new AbstractAnimal[num];
        for(int i = 0; i < num; i++){
            abstractAnimals[i] = createAnimal.create(AnimalTypes.values()
                    [new Random().nextInt(AnimalTypes.values().length)]);
        }
        return abstractAnimals;
    }
}
