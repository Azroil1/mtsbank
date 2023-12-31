package ru.mtsbank.hw.animal.herbivores;

import ru.mtsbank.hw.animal.AbstractAnimal;

import java.math.BigDecimal;

public abstract class Herbivores extends AbstractAnimal {
    public Herbivores(String breed, String name, BigDecimal cost, String character) {
        super(breed, name, cost, character);
    }
}
