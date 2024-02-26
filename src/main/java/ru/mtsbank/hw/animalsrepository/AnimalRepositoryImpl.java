package ru.mtsbank.hw.animalsrepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mtsbank.hw.animal.AbstractAnimal;
import ru.mtsbank.hw.animalservice.CreateAnimalService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class AnimalRepositoryImpl implements AnimalRepository {

    private AbstractAnimal[] animals;

    public AbstractAnimal[] getAnimals() {
        return animals;
    }

    public void setAnimals(AbstractAnimal[] animals) {
        this.animals = animals;
    }


    private CreateAnimalService createAnimalService;

    @Autowired
    public AnimalRepositoryImpl(CreateAnimalService createAnimalService) {
        this.createAnimalService = createAnimalService;
        animals = new AbstractAnimal[7];
        for (int i = 0; i < 7; i++) {
            animals[i] = createAnimalService.createAnimal();
        }
    }

    @Override
    public AbstractAnimal[] findLeapYearNames() {
        List<AbstractAnimal> list = new ArrayList<>();
        for (AbstractAnimal animal : animals) {
            if (animal.getBirthDate() != null) {
                if (animal.getBirthDate().isLeapYear()) {
                    list.add(animal);
                }
            }
        }
        AbstractAnimal[] abstractAnimals = new AbstractAnimal[list.size()];
        return list.toArray(abstractAnimals);
    }

    @Override
    public AbstractAnimal[] findOlderAnimal(int N) {
        List<AbstractAnimal> list = new ArrayList<>();
        for (AbstractAnimal animal : animals) {
            if (animal.getBirthDate() != null) {
                if (LocalDate.now().getYear() - animal.getBirthDate().getYear() <= N) {
                    list.add(animal);
                }
            }
        }
        AbstractAnimal[] abstractAnimals = new AbstractAnimal[list.size()];
        return list.toArray(abstractAnimals);
    }

    @Override
    public List<AbstractAnimal> findDuplicate()  {
        List<AbstractAnimal> animalList = new ArrayList<>();
        Set<AbstractAnimal> animalSet = new HashSet<>();
        animalSet.addAll(List.of(animals));
        animalList.addAll(List.of(animals));
        for (AbstractAnimal i : animalSet){
            animalList.remove(i);
        }
        animalSet.clear();
        animalSet.addAll(animalList);
        animalList.clear();
        animalList.addAll(animalSet);
        System.out.println(animalList);
        return animalList;
    }
    public void printDuplicate(){
        List<AbstractAnimal> list = findDuplicate();
        for(AbstractAnimal animal:list){
            System.out.println(animal);
        }
    }
}
