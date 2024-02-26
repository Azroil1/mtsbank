package ru.mtsbank.hw.animalsrepository;

import org.springframework.stereotype.Component;
import ru.mtsbank.hw.animal.AbstractAnimal;

import java.util.Comparator;

@Component
public class AnimalComparator implements Comparator<AbstractAnimal> {

    @Override
    public int compare(AbstractAnimal o1, AbstractAnimal o2) {
        return Integer.compare(o1.getBirthDate().getYear(), o2.getBirthDate().getYear());
    }
}
