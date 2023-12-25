package ru.mtsbank.hw4.animal.fish;

import ru.mtsbank.hw4.animal.AbstractAnimal;

import java.math.BigDecimal;

public abstract class Fish extends AbstractAnimal {
    public Fish(String breed, String name, BigDecimal cost, String character) {
        super(breed, name, cost, character);
    }
}
