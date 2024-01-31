package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import ru.mtsbank.hw.animal.predator.models.Wolf;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


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
