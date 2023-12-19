package ru.mtsbank.HW3.Animal.Fish;

import ru.mtsbank.HW3.Animal.AbstractAnimal;

import java.math.BigDecimal;

public abstract class Fish extends AbstractAnimal {
    public Fish(String breed, String name, BigDecimal cost, String character) {
        super(breed, name, cost, character);
    }
}
