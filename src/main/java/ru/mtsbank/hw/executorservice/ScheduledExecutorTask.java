package ru.mtsbank.hw.executorservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mtsbank.hw.animalsrepository.AnimalRepositoryImpl;
import ru.mtsbank.hw.exceptions.EmptyListException;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class ScheduledExecutorTask {
    @Autowired
    private AnimalRepositoryImpl animalRepository;

    private ScheduledExecutorService scheduledExecutorService;

    public ScheduledExecutorTask(){
        this.scheduledExecutorService = Executors.newScheduledThreadPool(2);
    }

    public void executorPrintAnimal(){
        scheduledExecutorService.scheduleAtFixedRate(()->{
            System.out.println("Thread PrintAnimal");
            animalRepository.printDuplicate();
        }, 0, 10, TimeUnit.SECONDS
        );
    }

    public void executorFindAvrAge(){
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("Thread animalRepository findAvrAge");
            try{
               double age = animalRepository.findAverageAge();
               System.out.println(age);
            }catch(EmptyListException e){
                e.getMessage();
            }
        },0,20, TimeUnit.SECONDS
        );
    }


}
