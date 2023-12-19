package ru.mtsbank.HW3;

import ru.mtsbank.HW3.Animal.Animal;
import ru.mtsbank.HW3.AnimalService.CreateAnimalServiceImpl;

public class Main {
    public static void main(String[] args) {
       CreateAnimalServiceImpl service = new CreateAnimalServiceImpl();
       service.createAnimal();
       service.createAnimal(5);
    }
}
