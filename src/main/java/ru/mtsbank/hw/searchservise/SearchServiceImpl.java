package ru.mtsbank.hw.searchservise;

import ru.mtsbank.hw.animal.AbstractAnimal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    public void findDuplicate(AbstractAnimal[] animals)  {
        for(int i = 0; i < animals.length; i++){
            for(int j = i; j < animals.length; j++){
                if(animals[i].equals(animals[j])){
                    System.out.println(animals[j]);
                }
            }
        }
    }
}
