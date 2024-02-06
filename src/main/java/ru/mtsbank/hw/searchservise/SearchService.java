package ru.mtsbank.hw.searchservise;

import ru.mtsbank.hw.animal.AbstractAnimal;

import java.util.List;

public interface SearchService {
    /**
     * Метод находит всех животных которые родились в високосный год
     * */

    AbstractAnimal[] findLeapYearNames(AbstractAnimal[] animals);

    /**
     * Метод находит всех животных старших N лет
     * */
    AbstractAnimal[] findOlderAnimal(AbstractAnimal[] animals, int N);
    /**
     * Вывод дупликатов животных
     * */
    List<AbstractAnimal> findDuplicate(AbstractAnimal[] animals) throws CloneNotSupportedException;
}
