package ru.mtsbank.hw3.animal;

import java.math.BigDecimal;

public interface Animal {
    /**
     * Функция возвращения поля{@link AbstractAnimal#breed}
     * */
    String getBreed();
    /**
     * Функция возвращения поля{@link AbstractAnimal#name}
     * */
    String getName();
    /**
     * Функция возвращения поля{@link AbstractAnimal#cost}
     * */
    BigDecimal getCost();
    /**
     * Функция возвращения поля{@link AbstractAnimal#character}
     * */
    String getCharacter();
}
