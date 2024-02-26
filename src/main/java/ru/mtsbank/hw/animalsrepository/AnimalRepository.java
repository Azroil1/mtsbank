package ru.mtsbank.hw.animalsrepository;

import ru.mtsbank.hw.animal.AbstractAnimal;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface AnimalRepository {
    /**
     * Метод находит всех животных которые родились в високосный год
     * */

    Map<String, LocalDate> findLeapYearNames();

    /**
     * Метод находит всех животных старших N лет
     * */
    Map<AbstractAnimal,Integer> findOlderAnimal(int N);
    /**
     * Вывод дупликатов животных
     * */
     Map<String,Integer> findDuplicate() throws CloneNotSupportedException;

    void printDuplicate();
}
