package ru.mtsbank.hw.scheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.mtsbank.hw.animalsrepository.AnimalRepositoryImpl;

import java.util.Arrays;

@Component
public class SchuduledTask {

    @Autowired
    AnimalRepositoryImpl animalRepository;


    @Scheduled(fixedRate = 60000)
    public void getAnimalRepository(){
        System.out.println("Woooork!");
        animalRepository.printDuplicate();
        System.out.println("-----------------------------------------");
        System.out.println(animalRepository.findOlderAnimal(12));
        System.out.println("-----------------------------------------");
        System.out.println(animalRepository.findLeapYearNames());
    }
}
