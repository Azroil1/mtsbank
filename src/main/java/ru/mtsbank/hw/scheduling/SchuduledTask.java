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
        System.out.println(Arrays.toString(animalRepository.findLeapYearNames()));
        System.out.println("--------------------------------------");
        System.out.println(Arrays.toString(animalRepository.findOlderAnimal(10)));
    }
}
