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
     * Поиск дубликатов
     * */
     Map<String,List<AbstractAnimal>> findDuplicate() throws CloneNotSupportedException;

    /**
     * Вывод дупликатов
     */
    void printDuplicate();

    /**
     * Метод поиска среднего возраста животных
     */
    double findAverageAge(List<AbstractAnimal> animals);

    /**
     * Поиск животных старше 5 лет и которые стоят больше средней цены
     */
    List<AbstractAnimal> findOldExpensive(List<AbstractAnimal> animals);

    /**
     * Поиск 3 животных с самой низкой ценой
     * @param animals
     * @return
     */
    List<AbstractAnimal> findMinCostAnimals(List<AbstractAnimal> animals);
}
