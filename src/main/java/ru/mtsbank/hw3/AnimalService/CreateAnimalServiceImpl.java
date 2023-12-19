package ru.mtsbank.hw3.AnimalService;

import ru.mtsbank.hw3.animal.fish.models.Barbus;
import ru.mtsbank.hw3.animal.fish.models.GoldFish;
import ru.mtsbank.hw3.animal.fish.models.Guppy;
import ru.mtsbank.hw3.animal.herbivores.models.Cow;
import ru.mtsbank.hw3.animal.pet.models.Cat;
import ru.mtsbank.hw3.animal.pet.models.Dog;
import ru.mtsbank.hw3.animal.pet.models.Hamster;
import ru.mtsbank.hw3.animal.predator.models.Lion;
import ru.mtsbank.hw3.animal.predator.models.Shark;
import ru.mtsbank.hw3.animal.predator.models.Wolf;

import java.math.BigDecimal;

public class CreateAnimalServiceImpl implements CreateAnimalService {

    public void createAnimal(int number) {
        for(int i = 0; i < number; i++){
            int remains = i%10;
            switch (remains) {
                case 0:
                    System.out.println(new Cat("Чиширская", "Барсик",
                            new BigDecimal(123.5698), "Агресивный"));
                    break;
                case 1:
                    System.out.println(new Dog("Дворняга","Шарик",
                            new BigDecimal(300.123),"Дружелюбный"));
                    break;
                case 2:
                    System.out.println(new Hamster("Обыкновенный хомяк", "Кругляш",
                            new BigDecimal(543), "Ленивый"));
                    break;
                case 3:
                    System.out.println(new Barbus("Барбус Алый","Немо",
                            new BigDecimal(1000.9999), "Нет"));
                    break;
                case 4:
                    System.out.println( new Guppy("Гуппи", "Губка-Боп",
                            new BigDecimal(10943.3232),"Ну такой"));
                    break;
                case 5:
                    System.out.println(new GoldFish("Золотая-рыбка", "Чудо",
                            new BigDecimal(3213.22),"Богатый" ));
                    break;
                case 6:
                    System.out.println(new Shark("Белая", "Killer","Agresive"));
                    break;
                case 7:
                    System.out.println(new Wolf("Simple", "Volk", "Killer"));
                    break;
                case 8:
                    System.out.println(new Lion("Simle", "Korol", "Pain"));
                    break;
                case 9:
                    System.out.println(new Cow("Red", "Burenka",
                            new BigDecimal(200000.9872),"Pain"));
                    break;
            }

        }
    }

    @Override
    public void createAnimal() {
        int i = 0;
        do{
            CreateAnimalService.super.createAnimal();
            i++;
        }
        while (i < 10);
        }
    }
