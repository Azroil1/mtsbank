package ru.mtsbank.HW3.AnimalService;

import ru.mtsbank.HW3.Animal.Animal;
import ru.mtsbank.HW3.Animal.Fish.ModelsFish.Barbus;
import ru.mtsbank.HW3.Animal.Fish.ModelsFish.GoldFish;
import ru.mtsbank.HW3.Animal.Fish.ModelsFish.Guppy;
import ru.mtsbank.HW3.Animal.Herbivores.Models.Cow;
import ru.mtsbank.HW3.Animal.Pet.ModelPet.Cat;
import ru.mtsbank.HW3.Animal.Pet.ModelPet.Dog;
import ru.mtsbank.HW3.Animal.Pet.ModelPet.Hamster;
import ru.mtsbank.HW3.Animal.Predator.ModelPredator.Lion;
import ru.mtsbank.HW3.Animal.Predator.ModelPredator.Shark;
import ru.mtsbank.HW3.Animal.Predator.ModelPredator.Wolf;
import ru.mtsbank.HW3.AnimalService.CreateAnimalService;

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
                    System.out.println(new Shark("Белая", "Killer",
                            new BigDecimal(0),"Agresive"));
                    break;
                case 7:
                    System.out.println(new Wolf("Simple", "Volk",
                            new BigDecimal(0),"Killer"));
                    break;
                case 8:
                    System.out.println(new Lion("Simle", "Korol",
                            new BigDecimal(1000000000.012321424),"Pain"));
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
