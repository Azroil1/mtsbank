package ru.mtsbank.hw3.animal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class AbstractAnimal implements Animal {
    protected String breed;
    protected String name;
    protected BigDecimal cost;
    protected String character;

    public AbstractAnimal(String breed, String name, BigDecimal cost, String character) {
        this.breed = breed;
        this.name = name;
        this.cost= cost.setScale(2,RoundingMode.DOWN);
        this.character = character;
    }

    public AbstractAnimal(String breed, String name, String character) {
        this.breed = breed;
        this.name = name;
        this.character = character;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getCost() {
        return cost;
    }

    @Override
    public String getCharacter() {
        return character;
    }

    @Override
    public String toString() {
        return "AbstractAnimal{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                '}';
    }
}
