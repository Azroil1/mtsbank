package ru.mtsbank.HW3.Animal.Herbivores;

import ru.mtsbank.HW3.Animal.AbstractAnimal;

import java.math.BigDecimal;

public abstract class Herbivores extends AbstractAnimal {
    public Herbivores(String breed, String name, BigDecimal cost, String character) {
        super(breed, name, cost, character);
    }
}
