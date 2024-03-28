package ru.mtsbank.hw.animalsrepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mtsbank.hw.animal.AbstractAnimal;
import ru.mtsbank.hw.animalservice.CreateAnimalServiceImpl;
import ru.mtsbank.hw.exceptions.SizeAnimalListException;


import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        Objects.requireNonNull(createAnimalServiceImpl.getAnimalMap());
        Map<String,LocalDate> mapFindLeapYearNames;
        Stream<Map.Entry<String, List<AbstractAnimal>>> stream = createAnimalServiceImpl.getAnimalMap().entrySet().stream();
        mapFindLeapYearNames = stream.map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .filter(abstractAnimal -> abstractAnimal.getBirthDate() != null)
                .filter(abstractAnimal -> abstractAnimal.getBirthDate().isLeapYear())
                . collect(Collectors.toMap(AbstractAnimal::getName, AbstractAnimal::getBirthDate));
        return mapFindLeapYearNames;
    }

    Comparator<AbstractAnimal> abstractAnimalComparator = Comparator.comparing(AbstractAnimal::getBirthDate);

    @Override
    public Map<AbstractAnimal, Integer> findOlderAnimal(int findYears) throws IllegalArgumentException {
        if(findYears < 0){
            throw new IllegalArgumentException();
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

        return animalIntegerMap;
    }

    @Override
    public Map<String, List<AbstractAnimal>> findDuplicate()  {
        Objects.requireNonNull(createAnimalServiceImpl.getAnimalMap());
        Set<AbstractAnimal> abstractAnimalSet= new HashSet<>();
        return createAnimalServiceImpl.getAnimalMap().values().stream()
                .flatMap(Collection::stream)
                .filter(AbstractAnimal -> !abstractAnimalSet.add(AbstractAnimal))
                .collect(Collectors.groupingBy(AbstractAnimal::getAnimalType));
    }
    public void printDuplicate(){
        findDuplicate().values()
                .forEach(System.out::println);
    }

    @Override
    public double findAverageAge(List<AbstractAnimal> animals) throws NullPointerException {
        if(animals == null){
            throw new NullPointerException();
        }
        return animals.stream()
                .mapToInt(AbstractAnimal -> LocalDate.now().getYear() - AbstractAnimal.getBirthDate().getYear())
                .average()
                .orElseThrow(() -> new RuntimeException("Не удалось подсчиттаь возраст"));
    }

    @Override
    public List<AbstractAnimal> findOldExpensive(List<AbstractAnimal> animals) throws NullPointerException {
        Objects.requireNonNull(animals);
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
        return animals.stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .filter(AbstractAnimal -> AbstractAnimal.getCost() != null)
                .sorted(Comparator.comparing(AbstractAnimal::getCost))
                .limit(3)
                .collect(Collectors.toList());
    }

}