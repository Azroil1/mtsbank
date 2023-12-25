package ru.mtsbank.hw3.animal.herbivores;

import ru.mtsbank.hw3.animal.AbstractAnimal;

import java.math.BigDecimal;

public abstract class Herbivores extends AbstractAnimal {
    public Herbivores(String breed, String name, BigDecimal cost, String character) {
        super(breed, name, cost, character);
    }
}
