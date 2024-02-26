package ru.mtsbank.hw.animalservice;

import ru.mtsbank.hw.animal.AbstractAnimal;

import java.util.List;
import java.util.Map;
import java.util.Random;

public interface CreateAnimalService {

    Map<String, List<AbstractAnimal>> createAnimal();

    /**
     * Метод который проверяет
     * к кому типу относиться животное
     * */
    default AbstractAnimal[] checkTypeAnimal(int num){
        CreateAnimal createAnimal = new CreateAnimal();
        AbstractAnimal[] abstractAnimals = new AbstractAnimal[num];
        int i = 0;
        while(i < num){
            abstractAnimals[i] = createAnimal.create(AnimalTypes.values()
                    [new Random().nextInt(AnimalTypes.values().length)]);
            i++;
        }
        return abstractAnimals;
        }
    }
