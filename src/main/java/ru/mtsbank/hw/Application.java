package ru.mtsbank.hw;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.mtsbank.hw.animal.AbstractAnimal;
import ru.mtsbank.hw.animalservice.CreateAnimalServiceImpl;
import ru.mtsbank.hw.animalsrepository.AnimalRepository;
import ru.mtsbank.hw.animalsrepository.AnimalRepositoryImpl;

import java.util.Arrays;


@ComponentScan
public class Application {
    public static void main(String[] args) throws CloneNotSupportedException {

        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        CreateAnimalServiceImpl animalService = context.getBean(CreateAnimalServiceImpl.class);
        AnimalRepositoryImpl animalRepository = context.getBean(AnimalRepositoryImpl.class);
        System.out.println(animalService.getTypes());
        System.out.println(animalRepository.findDuplicate(animalService.createAnimal(1000)));
        System.out.println(Arrays.toString(animalRepository.findLeapYearNames(animalService.createAnimal(45))));
        System.out.println(Arrays.toString(animalRepository.findOlderAnimal(animalService.createAnimal(100),5)));


    }
}
