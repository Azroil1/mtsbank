package ru.mtsbank.HW3.Animal.Pet;


import ru.mtsbank.HW3.Animal.AbstractAnimal;

import java.math.BigDecimal;

public  abstract class Pet extends AbstractAnimal {
    public Pet(String breed, String name, BigDecimal cost, String character) {
        super(breed, name, cost, character);
    }

}
