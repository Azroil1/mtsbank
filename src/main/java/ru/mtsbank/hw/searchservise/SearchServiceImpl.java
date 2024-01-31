package ru.mtsbank.hw.searchservise;

import ru.mtsbank.hw.animal.AbstractAnimal;

import java.time.LocalDate;
import java.util.*;

public class SearchServiceImpl implements SearchService{

    @Override
    public AbstractAnimal[] findLeapYearNames(AbstractAnimal[] animals) {
        List<AbstractAnimal> list = new ArrayList<>();
        for(int i = 0; i < animals.length; i++){
            if(animals[i].getBirthDate() != null) {
                if (animals[i].getBirthDate().isLeapYear()) {
                    list.add(animals[i]);
                }
            }
        }
        AbstractAnimal[] abstractAnimals = new AbstractAnimal[list.size()];
        return list.toArray(abstractAnimals);
    }

    @Override
    public AbstractAnimal[] findOlderAnimal(AbstractAnimal[] animals, int N) {
        List<AbstractAnimal> list = new ArrayList<>();
        for(int i = 0; i < animals.length; i++){
            if(animals[i].getBirthDate() != null) {
                if (LocalDate.now().getYear() - animals[i].getBirthDate().getYear() <= N) {
                    list.add(animals[i]);
                }
            }
        }
        AbstractAnimal[] abstractAnimals = new AbstractAnimal[list.size()];
        return list.toArray(abstractAnimals);
    }

    @Override
    public List<AbstractAnimal> findDuplicate(AbstractAnimal[] animals)  {
        List<AbstractAnimal> animalList = new ArrayList<>();
        Map<AbstractAnimal, Integer> animalIntegerMap = new HashMap<>();
        for(int i = 0; i < animals.length; i++) {
            if (animalIntegerMap.containsKey(animals[i])) {
                animalList.add(animals[i]);
            } else {
                animalIntegerMap.put(animals[i], 1);
            }
        }
        return animalList;
    }
}
