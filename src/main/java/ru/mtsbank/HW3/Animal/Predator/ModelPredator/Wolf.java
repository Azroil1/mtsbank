package ru.mtsbank.HW3.Animal.Predator.ModelPredator;

import ru.mtsbank.HW3.Animal.Predator.Predator;

import java.math.BigDecimal;

public class Wolf extends Predator {

        public Wolf(String breed, String name, BigDecimal cost, String character) {
        super(breed, name, cost, character);
    }

    public static class Shark extends Predator {

        public Shark(String breed, String name, BigDecimal cost, String character) {
            super(breed, name, cost, character);
        }
    }
}
