package ru.mtsbank.hw.animalservice;

import org.springframework.stereotype.Component;
import ru.mtsbank.hw.animal.AbstractAnimal;
import ru.mtsbank.hw.animal.fish.models.Barbus;
import ru.mtsbank.hw.animal.fish.models.GoldFish;
import ru.mtsbank.hw.animal.fish.models.Guppy;
import ru.mtsbank.hw.animal.herbivores.models.Cow;
import ru.mtsbank.hw.animal.pet.models.Cat;
import ru.mtsbank.hw.animal.pet.models.Dog;
import ru.mtsbank.hw.animal.pet.models.Hamster;
import ru.mtsbank.hw.animal.predator.models.Lion;
import ru.mtsbank.hw.animal.predator.models.Shark;
import ru.mtsbank.hw.animal.predator.models.Wolf;

import java.math.BigDecimal;

@Component
public class CreateAnimal {
    public AbstractAnimal create(AnimalTypes types){
        AbstractAnimal animal;
        switch (types) {
            case CAT:
                animal = new Cat("Чиширская", "Барсик",
                        new BigDecimal(123.5698), "Агресивный");
                break;
            case DOG:
                animal = new Dog("Дворняга","Шарик",
                        new BigDecimal(300.123),"Дружелюбный");
                break;
            case HAMSTER:
                animal = new Hamster("Обыкновенный хомяк", "Кругляш",
                        new BigDecimal(543), "Ленивый");
                break;
            case BARBUS:
                animal = new Barbus("Барбус Алый","Немо",
                        new BigDecimal(1000.9999), "Нет");
                break;
            case GUPPY:
                animal = new Guppy("Гуппи", "Губка-Боп",
                        new BigDecimal(10943.3232),"Ну такой");
                break;
            case GOLDFISH:
                animal = new GoldFish("Золотая-рыбка", "Чудо",
                        new BigDecimal(3213.22),"Богатый" );
                break;
            case SHARK:
                animal = new Shark("Белая", "Killer","Agresive");
                break;
            case WOLF:
                animal = new Wolf("Simple", "Volk", "Killer");
                break;
            case LION:
                animal = new Lion("Simle", "Korol", "Pain");
                break;
            case COW:
                animal = new Cow("Red", "Burenka",
                        new BigDecimal(200000.9872),"Pain");
                break;
            default:
                throw new IllegalArgumentException("Wrong type: " + types);
        }
        return animal;
    }
}
