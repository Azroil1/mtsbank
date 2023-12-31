package ru.mtsbank.hw.animal.pet.models;

import ru.mtsbank.hw.animal.pet.Pet;

import java.math.BigDecimal;

public class Dog extends Pet {
    public Dog(String bread, String name, BigDecimal cost, String character) {
        super(bread, name, cost, character);
    }
}
