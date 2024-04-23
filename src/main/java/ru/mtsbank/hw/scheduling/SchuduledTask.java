package ru.mtsbank.hw.scheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.mtsbank.hw.animalsrepository.AnimalRepositoryImpl;
import ru.mtsbank.hw.database.AnimalsDataBaseJDBC;
import ru.mtsbank.hw.exceptions.SizeAnimalListException;
import ru.mtsbank.hw.executorservice.ScheduledExecutorTask;
import ru.mtsbank.hw.modelsanimalsdatabase.Creature;
import ru.mtsbank.hw.serializers.ObjectMapperAnimalsForJSON;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

@Component
public class SchuduledTask {
    @Autowired
    AnimalRepositoryImpl animalRepository;

    @Autowired
    private ScheduledExecutorTask scheduledExecutorTask;
    @Autowired
    private AnimalsDataBaseJDBC dataBaseJDBC;

    private List<Creature> creatureList;

    @Scheduled(fixedRate = 60000)
    public void getAnimalRepository() throws SizeAnimalListException {
        System.out.println("Woooork!");
        try {
            System.out.println(animalRepository.findMinCostAnimals());
        } catch (SizeAnimalListException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------");
        try {
            System.out.println(animalRepository.findOlderAnimal(10));
        }catch (IllegalArgumentException exception){
            exception.printStackTrace();
        }
        System.out.println("-----------------------------------------");
        System.out.println(animalRepository.findLeapYearNames());
        System.out.println("-----------------------------------------");
        System.out.println(animalRepository.findAverageAge());
        try {
            System.out.println(ObjectMapperAnimalsForJSON.readAnimalFromJson("findMinCostAnimals.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("--------------------------");
        System.out.println(dataBaseJDBC.getListCreature());
        System.out.println(dataBaseJDBC.getListHabitat());
        System.out.println(dataBaseJDBC.getListProvider());

}

    @PostConstruct
    public void startTreads(){
        scheduledExecutorTask.executorFindAvrAge();
        scheduledExecutorTask.executorPrintAnimal();
    }
}
