package ru.mtsbank.hw.animalservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mtsbank.hw.animal.AbstractAnimal;
import ru.mtsbank.hw.animal.fish.Fish;
import ru.mtsbank.hw.animal.herbivores.Herbivores;
import ru.mtsbank.hw.animal.pet.Pet;
import ru.mtsbank.hw.config.AnimalProperties;
import ru.mtsbank.hw.animalservice.AnimalTypes;

import java.util.*;

@Component
public class CreateAnimalServiceImpl implements CreateAnimalService {

    private Map<String,List<AbstractAnimal>> animalMap;

    AnimalTypes types;

    @Autowired
    CreateAnimal createAnimal;

    AnimalProperties properties;

    public CreateAnimalServiceImpl(AnimalProperties properties) {
        this.properties = properties;
        if(animalMap == null){
            animalMap = new HashMap<>();
        }
    }

    @Override
    public Map<String, List<AbstractAnimal>> createAnimal() {
        AbstractAnimal abstractAnimals;
        types = AnimalTypes.values()[new Random().nextInt(AnimalTypes.values().length)];
            abstractAnimals = createAnimal.create(types);
            if(abstractAnimals instanceof Fish){
                abstractAnimals.setName(properties.getFishNames());
                abstractAnimals.setAnimalType(AnimalTypes.GOLDFISH.toString());

            } else if (abstractAnimals instanceof Herbivores) {
                abstractAnimals.setName(properties.getHerbivoresNames());
                abstractAnimals.setAnimalType(AnimalTypes.COW.toString());
            } else if (abstractAnimals instanceof Pet) {
                abstractAnimals.setName(properties.getPetNames());
                abstractAnimals.setAnimalType(AnimalTypes.CAT.toString());
            } else {
                abstractAnimals.setName(properties.getPredatorNames());
                abstractAnimals.setAnimalType(AnimalTypes.WOLF.toString());
            }
        if(animalMap.containsKey(types.toString())){
            animalMap.get(types.toString()).add(abstractAnimals);
        }
        else{
            List<AbstractAnimal> list = new ArrayList<>();
            list.add(abstractAnimals);
            animalMap.put(types.toString(),list);
        }
        return animalMap;
    }

    public AnimalTypes getTypes() {
        return types;
    }

    public void setTypes(AnimalTypes types) {
        this.types = types;
    }

    public Map<String, List<AbstractAnimal>> getAnimalMap() {
        return animalMap;
    }

    public void setAnimalMap(Map<String, List<AbstractAnimal>> animalMap) {
        this.animalMap = animalMap;
    }
}
