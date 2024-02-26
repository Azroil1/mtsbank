package ru.mtsbank.hw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import ru.mtsbank.hw.animal.predator.models.Wolf;

import java.time.LocalDate;



public class AnimalTests {
    @Mock
    public static Wolf wolf;

    @BeforeAll
    public static void initWolf(){
         wolf = new Wolf("Серый","Акела", "Спокойный");
         wolf.setBirthDate(LocalDate.now());
    }

    @Test
    @DisplayName("Test equals animal")
    public void equalsAnimal(){
        initWolf();
        Wolf wolf1 = new Wolf("Серый","Акела", "Спокойный");
        wolf1.setBirthDate(LocalDate.now());
        Assertions.assertEquals(true,wolf.equals(wolf1));
    }

    @Test
    @DisplayName("Test false equals animal")
    public void equalsFalseTest(){
        initWolf();
        Wolf wolf1 = new Wolf("Серый","Балу","Спокойный");
        wolf1.setBirthDate(LocalDate.now());
        Assertions.assertEquals(false,wolf.equals(wolf1));
    }
}
