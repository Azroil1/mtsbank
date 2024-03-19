package ru.mtsbank.hw.animalsrepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mtsbank.hw.animal.AbstractAnimal;
import ru.mtsbank.hw.animalservice.CreateAnimalService;
import ru.mtsbank.hw.animalservice.CreateAnimalServiceImpl;

import java.time.LocalDate;
import java.util.*;

import static java.lang.Integer.compare;

@Repository
public class AnimalRepositoryImpl implements AnimalRepository {


    @Autowired
    private CreateAnimalServiceImpl createAnimalServiceImpl;

    @Autowired
    public AnimalRepositoryImpl(CreateAnimalServiceImpl createAnimalServiceImpl) {
        this.createAnimalServiceImpl = createAnimalServiceImpl;
        for (int i = 0; i < 7; i++) {
            createAnimalServiceImpl.createAnimal();
        }
    }

    @Override
    public Map<String,LocalDate> findLeapYearNames() {
        Map<String,LocalDate> mapFindLeapYearNames = new HashMap<>();
        for (Map.Entry<String, List<AbstractAnimal>> entry : createAnimalServiceImpl.getAnimalMap().entrySet()) {
            for(AbstractAnimal animal : entry.getValue()){
                if(animal.getBirthDate().isLeapYear()){
                    mapFindLeapYearNames.put(entry.getKey() + " " + animal.getName(), animal.getBirthDate());
                }
            }
        }
        return mapFindLeapYearNames;
    }

    Comparator<AbstractAnimal> abstractAnimalComparator = (a1,a2) -> a1.getBirthDate().compareTo(a2.getBirthDate());

    @Override
    public Map<AbstractAnimal, Integer> findOlderAnimal(int findYears) {
        Map<AbstractAnimal, Integer> animalIntegerMap = new HashMap<>();
        AbstractAnimal olderAnimal = null;
        for (Map.Entry<String,List<AbstractAnimal>> entry : createAnimalServiceImpl.getAnimalMap().entrySet()) {
            for(AbstractAnimal animal : entry.getValue()){
                if(LocalDate.now().getYear() - animal.getBirthDate().getYear() >= findYears){
                    animalIntegerMap.put(animal, LocalDate.now().getYear() - animal.getBirthDate().getYear());
                }
                if (olderAnimal != null) {
                    if(abstractAnimalComparator.compare(olderAnimal,animal) > 0) {
                        olderAnimal = animal;
                    }
                } else {
                    olderAnimal = animal;
                }
            }
        }
        if(animalIntegerMap.isEmpty()){
            animalIntegerMap.put(olderAnimal, LocalDate.now().getYear() - olderAnimal.getBirthDate().getYear());
        }

        return animalIntegerMap;
    }

    @Override
    public Map<String, Integer> findDuplicate()  {
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        Set<AbstractAnimal> abstractAnimalSet = new HashSet<>();
        for(Map.Entry<String, List<AbstractAnimal>> entry: createAnimalServiceImpl.getAnimalMap().entrySet()){
            abstractAnimalSet.addAll(entry.getValue());
            List<AbstractAnimal> listTypeAnimal = new ArrayList<>(entry.getValue());
            for(AbstractAnimal animal : abstractAnimalSet){
                listTypeAnimal.remove(animal);
            }
            if(listTypeAnimal.size() != 0) {
                stringIntegerMap.put(entry.getKey(), listTypeAnimal.size());
            }
        }
        return stringIntegerMap;
    }
    public void printDuplicate(){
        Map<String,Integer> stringIntegerMap = findDuplicate();
        for(Map.Entry<String,Integer> entry: stringIntegerMap.entrySet()){
            System.out.println(entry.getValue() + " = " + entry.getValue());
        }
    }
}