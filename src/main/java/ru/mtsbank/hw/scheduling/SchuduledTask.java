package ru.mtsbank.hw.scheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.mtsbank.hw.animalsrepository.AnimalRepositoryImpl;
import ru.mtsbank.hw.exceptions.SizeAnimalListException;
import ru.mtsbank.hw.executorservice.ScheduledExecutorTask;

import javax.annotation.PostConstruct;

@Component
public class SchuduledTask {
    @Autowired
    AnimalRepositoryImpl animalRepository;

    @Autowired
    private ScheduledExecutorTask scheduledExecutorTask;

    @Scheduled(fixedRate = 60000)
    public void getAnimalRepository(){
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
    }

    @PostConstruct
    public void startTreads(){
        scheduledExecutorTask.executorFindAvrAge();
        scheduledExecutorTask.executorPrintAnimal();
    }
}
