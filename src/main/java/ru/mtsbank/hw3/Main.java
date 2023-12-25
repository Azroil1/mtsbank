package ru.mtsbank.hw3;

import ru.mtsbank.hw3.AnimalService.CreateAnimalServiceImpl;

public class Main {
    public static void main(String[] args) {
       CreateAnimalServiceImpl service = new CreateAnimalServiceImpl();
       service.createAnimal();
       service.createAnimal(5);
    }
}
