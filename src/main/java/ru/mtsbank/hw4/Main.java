package ru.mtsbank.hw4;

import ru.mtsbank.hw4.animalservice.CreateAnimalServiceImpl;
import ru.mtsbank.hw4.searchservise.SearchService;
import ru.mtsbank.hw4.searchservise.SearchServiceImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        CreateAnimalServiceImpl createAnimalService = new CreateAnimalServiceImpl();
        SearchService service = new SearchServiceImpl();
        System.out.println(Arrays.toString(service.findLeapYearNames(createAnimalService.createAnimal(23))));
        System.out.println(Arrays.deepToString(service.findOlderAnimal(createAnimalService.createAnimal(),5)));
        service.findDuplicate(createAnimalService.createAnimal());
    }
}
