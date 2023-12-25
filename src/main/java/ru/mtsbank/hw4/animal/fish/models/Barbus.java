package ru.mtsbank.hw4.animal.fish.models;

import ru.mtsbank.hw4.animal.fish.Fish;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Barbus extends Fish {

    public Barbus(String breed, String name, BigDecimal cost, String character) {
        super(breed, name, cost, character);
    }

    @Override
    public LocalDate getBirthDate() {
        return null;
    }
}
