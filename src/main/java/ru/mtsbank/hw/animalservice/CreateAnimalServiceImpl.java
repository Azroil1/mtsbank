package ru.mtsbank.hw.animalservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.mtsbank.hw.animal.AbstractAnimal;

import java.util.Random;


@Service
@Scope("prototype")
public class CreateAnimalServiceImpl implements CreateAnimalService {

    protected AnimalTypes types;
    @Autowired
    private CreateAnimal createAnimal;

    public AbstractAnimal[] createAnimal(int num) {
        AbstractAnimal[] abstractAnimals = new AbstractAnimal[num];
        for(int i = 0; i < num; i++){
            abstractAnimals[i] = createAnimal.create(AnimalTypes.values()
                    [new Random().nextInt(AnimalTypes.values().length)]);
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
