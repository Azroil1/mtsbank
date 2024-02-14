package ru.mtsbank.hw.animalsrepository;

import ru.mtsbank.hw.animal.AbstractAnimal;

import java.util.List;

public interface AnimalRepository {
    /**
     * Метод находит всех животных которые родились в високосный год
     * */

    AbstractAnimal[] findLeapYearNames();

    /**
     * Метод находит всех животных старших N лет
     * */
    AbstractAnimal[] findOlderAnimal(int N);
    /**
     * Вывод дупликатов животных
     * */
    List<AbstractAnimal> findDuplicate() throws CloneNotSupportedException;

    void printDuplicate();
}
