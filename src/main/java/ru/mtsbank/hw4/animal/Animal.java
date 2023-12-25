package ru.mtsbank.hw4.animal;

import ru.mtsbank.hw4.animal.AbstractAnimal;

import java.math.BigDecimal;
import java.time.LocalDate;

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

    /**
     * Функция возвращает поля
     * */
    LocalDate getBirthDate();
}
