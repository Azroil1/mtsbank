package ru.mtsbank.hw.animalservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mtsbank.hw.animal.AbstractAnimal;
import ru.mtsbank.hw.animal.fish.Fish;
import ru.mtsbank.hw.animal.herbivores.Herbivores;
import ru.mtsbank.hw.animal.pet.Pet;
import ru.mtsbank.hw.config.AnimalProperties;
import ru.mtsbank.hw.entity.Creature;
import ru.mtsbank.hw.repository.CreatureRepository;
import ru.mtsbank.hw.service.AnimalTypes;
import ru.mtsbank.hw.service.CreateAnimal;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
public class CreateAnimalServiceImpl implements CreateAnimalService {

    private Map<String, List<AbstractAnimal>> animalMap;

    @Autowired
    private CreatureRepository creatureRepository;

    AnimalTypes type;

    @Autowired
    CreateAnimal createAnimal;

    AnimalProperties properties;
    private Path path = Paths.get("C:\\Users\\Amir\\Desktop\\mts\\src\\main\\resources\\animals\\logData.txt");

    static long counterAnimals;

    public CreateAnimalServiceImpl(AnimalProperties properties) {
        this.properties = properties;
        animalMap = new ConcurrentHashMap<>();
    }

    @PostConstruct
    public void createNewFile(){
        if(Files.exists(path)){
            try {
                Files.delete(path);
                System.out.println("File delete");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Files.createFile(path);
            System.out.println("File create");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Map<String, List<AbstractAnimal>> createAnimal() {
        AbstractAnimal abstractAnimals;
        AnimalTypes types = AnimalTypes.values()[new Random().nextInt(AnimalTypes.values().length)];
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
        if(Files.exists(path)){
            counterAnimals++;

            String animalToString = counterAnimals + " " + abstractAnimals.getBreed() + " " + abstractAnimals.getName();
            if(abstractAnimals.getCost() != null){
                animalToString += " " + abstractAnimals.getCost().toString();
            }

            animalToString += " " + abstractAnimals.getBirthDate().toString();
            try {
                Files.writeString(path, animalToString + "\n", StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return animalMap;
    }

    public AnimalTypes getTypes() {
        return type;
    }

    public void setTypes(AnimalTypes type) {
        this.type = type;
    }

    public Map<String, List<AbstractAnimal>> getAnimalMap() {
        return animalMap;
    }

    public void setAnimalMap(Map<String, List<AbstractAnimal>> animalMap) {
        this.animalMap = animalMap;
    }

    public Map<String,List<Creature>> getListCreature(){
        return creatureRepository.findAll().stream().collect(Collectors.groupingBy(c -> c.getBreed().getType()));
    }


}
