package ru.mtsbank.hw.animalsrepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mtsbank.hw.animal.AbstractAnimal;
import ru.mtsbank.hw.animalservice.CreateAnimalServiceImpl;
import ru.mtsbank.hw.annatation.PublicLogger;
import ru.mtsbank.hw.exceptions.EmptyListException;
import ru.mtsbank.hw.exceptions.NonValidArgumentException;
import ru.mtsbank.hw.exceptions.SizeAnimalListException;
import ru.mtsbank.hw.serializers.ObjectMapperAnimalsForJSON;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class AnimalRepositoryImpl implements AnimalRepository {
    @Autowired
    private CreateAnimalServiceImpl createAnimalServiceImpl;

    @Autowired
    public AnimalRepositoryImpl(CreateAnimalServiceImpl createAnimalServiceImpl) {
        this.createAnimalServiceImpl = createAnimalServiceImpl;
    }

    @PostConstruct
    public void createAnimal(){
        for(int i = 0; i < 7; i++){
            createAnimalServiceImpl.createAnimal();
        }
    }
    @PublicLogger(value = "findLeapYearsName work", entering = true)
    @Override
    public Map<String,LocalDate> findLeapYearNames() {
        String check = check();
        Objects.requireNonNull(createAnimalServiceImpl.getAnimalMap());
        Map<String,LocalDate> mapFindLeapYearNames;
        Stream<Map.Entry<String, List<AbstractAnimal>>> stream = createAnimalServiceImpl.getAnimalMap().entrySet().stream();
        mapFindLeapYearNames = stream.map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .filter(abstractAnimal -> abstractAnimal.getBirthDate() != null)
                .filter(abstractAnimal -> abstractAnimal.getBirthDate().isLeapYear())
                . collect(Collectors.toMap(AbstractAnimal::getName, AbstractAnimal::getBirthDate));
        ObjectMapperAnimalsForJSON.animalMapJson(mapFindLeapYearNames, "findLeapYearNames.json");

        return new ConcurrentHashMap<>(mapFindLeapYearNames);
    }

    Comparator<AbstractAnimal> abstractAnimalComparator = Comparator.comparing(AbstractAnimal::getBirthDate);

    @Override
    public Map<AbstractAnimal, Integer> findOlderAnimal(int findYears) throws IllegalArgumentException {
        if(findYears < 0){
            throw new NonValidArgumentException("возраст не может быть меньше 0");
        }
        Objects.requireNonNull(createAnimalServiceImpl.getAnimalMap());
        Map<AbstractAnimal, Integer> animalIntegerMap;
        Stream<Map.Entry<String, List<AbstractAnimal>>> stream = createAnimalServiceImpl.getAnimalMap().entrySet().stream();
        animalIntegerMap = stream.map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                .filter(abstractAnimal -> abstractAnimal.getBirthDate() != null)
                .filter(abstractAnimal -> abstractAnimal.getBirthDate().getYear() >= findYears)
                .collect(Collectors.toMap(AbstractAnimal -> AbstractAnimal, AbstractAnimal -> AbstractAnimal.getBirthDate().getYear() ));
        if (animalIntegerMap.isEmpty()){
            Optional<AbstractAnimal> stream1 = createAnimalServiceImpl.getAnimalMap().values().stream()
                    .flatMap(Collection::stream)
                    .max(abstractAnimalComparator);
            if(stream1.isPresent()) {
                animalIntegerMap.put(stream1.get(), stream1.get().getBirthDate().getYear());
            }
        }
        ObjectMapperAnimalsForJSON.animalMapJson(animalIntegerMap, "findOlderAnimal.json");

        return new ConcurrentHashMap<>(animalIntegerMap);
    }

    @Override
    public Map<String, List<AbstractAnimal>> findDuplicate()  {
        Objects.requireNonNull(createAnimalServiceImpl.getAnimalMap());
        Set<AbstractAnimal> abstractAnimalSet= new HashSet<>();
        Map<String,List<AbstractAnimal>> findDuplicateMap = createAnimalServiceImpl.getAnimalMap().values().stream()
                .flatMap(Collection::stream)
                .filter(AbstractAnimal -> !abstractAnimalSet.add(AbstractAnimal))
                .collect(Collectors.groupingBy(AbstractAnimal::getAnimalType));
        ObjectMapperAnimalsForJSON.animalMapJson(findDuplicateMap, "findDuplicate.json");
        return new ConcurrentHashMap<>(findDuplicateMap);
    }
    public void printDuplicate(){
        findDuplicate().values()
                .forEach(System.out::println);
    }

    @Override
    public double findAverageAge() throws EmptyListException {
        List<List<AbstractAnimal>> animals = new ArrayList<>( createAnimalServiceImpl
                .getAnimalMap().values());
        if(animals.isEmpty()){
            throw new EmptyListException("пустой лист");
        }
        return animals.stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .filter(abstractAnimal -> abstractAnimal.getBirthDate() != null)
                .mapToDouble(AbstractAnimal -> LocalDate.now().getYear() - AbstractAnimal.getBirthDate().getYear())
                .average()
                .orElseThrow(() -> new RuntimeException("Не удалось подсчиттаь возраст"));
    }

    @Override
    public List<AbstractAnimal> findOldExpensive(List<AbstractAnimal> animals) throws EmptyListException {
        if(animals.isEmpty()){
            throw new EmptyListException("пустой лист");
        }
        OptionalDouble doubleStream = animals.stream()
                .filter(Objects::nonNull)
                .filter(AbstractAnimal -> AbstractAnimal.getCost() != null)
                .mapToDouble(AbstractAnimal -> AbstractAnimal.getCost().doubleValue())
                .average();
         return animals.stream()
                 .filter(Objects ::nonNull)
                .filter(AbstractAnimal -> AbstractAnimal.getCost() != null)
                .filter(AbstractAnimal -> AbstractAnimal.getCost().doubleValue() > doubleStream.getAsDouble())
                .filter(AbstractAnimal -> LocalDate.now().getYear() - AbstractAnimal.getBirthDate().getYear() > 5)
                .collect(Collectors.toList());
    }

    @Override
    public List<AbstractAnimal> findMinCostAnimals() throws SizeAnimalListException {
        List<List<AbstractAnimal>> animals = new ArrayList<>(createAnimalServiceImpl.getAnimalMap().values());
        int sizeAnimals = 0;
        for (List<AbstractAnimal> animal : animals) {
            sizeAnimals += animal.size();
        }
        if(sizeAnimals < 3){
            throw new SizeAnimalListException("Animal list size < 3");
        }
        List<AbstractAnimal> abstractAnimalList = animals.stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .filter(AbstractAnimal -> AbstractAnimal.getCost() != null)
                .sorted(Comparator.comparing(AbstractAnimal::getCost))
                .limit(3)
                .collect(Collectors.toList());
        ObjectMapperAnimalsForJSON.animalCollectionJson(abstractAnimalList, "findMinCostAnimals.json");
        return new CopyOnWriteArrayList<>(abstractAnimalList);
    }
    @PublicLogger(value = "Work check method", entering = true)
    private String check(){
        return "OK";
    }

}