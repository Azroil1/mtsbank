package ru.mtsbank.hw;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import ru.mtsbank.hw.Application;
import ru.mtsbank.hw.animal.AbstractAnimal;
import ru.mtsbank.hw.animal.fish.models.Barbus;
import ru.mtsbank.hw.animal.herbivores.models.Cow;
import ru.mtsbank.hw.animal.pet.models.Cat;
import ru.mtsbank.hw.animal.pet.models.Dog;
import ru.mtsbank.hw.animalservice.CreateAnimalService;
import ru.mtsbank.hw.animalsrepository.AnimalRepositoryImpl;
import ru.mtsbank.hw.config.AnimalProperties;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


@SpringBootTest
public class AnimalRepositoryImplTests {
    @Mock
    private CreateAnimalService createAnimalService;

    @Mock
    private AnimalProperties animalProperties;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Тест метода findLeapYears()")
    public void findLeapYearsTest() {
        AnimalRepositoryImpl animalRepository = new AnimalRepositoryImpl(createAnimalService);
        AbstractAnimal[] animals = {
                new Dog("fe", "ed", new BigDecimal(213.3), "fdf"),
                new Cat("fe", "ed", new BigDecimal(213.3), "fdf"),
                new Barbus("fe", "ed", new BigDecimal(213.3), "fdf"),
                new Cow("fe", "ed", new BigDecimal(213.3), "fdf"),
                new Dog("fe", "ed", new BigDecimal(213.3), "fdf"),
        };
        animals[0].setBirthDate(LocalDate.of(2015,4,20));
        animals[1].setBirthDate(LocalDate.of(2013,5,15));
        animals[2].setBirthDate(LocalDate.of(2010,11,13));
        animals[3].setBirthDate(LocalDate.of(2013,5,16));
        animals[4].setBirthDate(LocalDate.of(2016,1,19));
        animalRepository.setAnimals(animals);

        // Ожидаемые результаты для метода findLeapYearNames()
        AbstractAnimal[] expected = {animals[4]};
        System.out.println(Arrays.toString(animalRepository.findLeapYearNames()));

        Assertions.assertArrayEquals(animalRepository.findLeapYearNames(), expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 11})
    @DisplayName("Тест метода findOlderAnimal")
    public void findOlderAnimalTest(int values) {
        AnimalRepositoryImpl animalRepository = new AnimalRepositoryImpl(createAnimalService);
        AbstractAnimal[] animals = {
                new Dog("fe", "ed", new BigDecimal(213.3), "fdf"),
                new Cat("fe", "ed", new BigDecimal(213.3), "fdf"),
                new Barbus("fe", "ed", new BigDecimal(213.3), "fdf"),
                new Cat("fe", "ed", new BigDecimal(213.3), "fdf"),
                new Dog("fe", "ed", new BigDecimal(213.3), "fdf"),
        };
        animals[0].setBirthDate(LocalDate.of(2015,4,20));
        animals[1].setBirthDate(LocalDate.of(2013,5,16));
        animals[2].setBirthDate(LocalDate.of(2016,11,13));
        animals[3].setBirthDate(LocalDate.of(2013,5,16));
        animals[4].setBirthDate(LocalDate.of(2016,1,19));
        animalRepository.setAnimals(animals);

        // Ожидаемый результат для метода findOlderAnimal()
        if (values == 7) {
            Assertions.assertArrayEquals(animalRepository.findOlderAnimal(values), new AbstractAnimal[] {animals[1]});
        } else {
            System.out.println(Arrays.toString(animalRepository.findOlderAnimal(values)));
            Assertions.assertArrayEquals(animalRepository.findOlderAnimal(values), animals);
        }
    }

    @Test
    @DisplayName("Тест метода findDuplicate")
    public void findDuplicate() {
        AnimalRepositoryImpl animalRepository = new AnimalRepositoryImpl(createAnimalService);
        AbstractAnimal[] animals = {
                new Dog("fe", "ed", new BigDecimal(213.3), "fdf"),
                new Cat("fe", "ed", new BigDecimal(213.3), "fdf"),
                new Barbus("fe", "ed", new BigDecimal(213.3), "fdf"),
                new Cat("fe", "ed", new BigDecimal(213.3), "fdf"),
                new Dog("fe", "ed", new BigDecimal(213.3), "fdf"),
        };
        animals[0].setBirthDate(LocalDate.of(2015,4,20));
        animals[1].setBirthDate(LocalDate.of(2013,5,16));
        animals[2].setBirthDate(LocalDate.of(2016,11,13));
        animals[3].setBirthDate(LocalDate.of(2013,5,16));
        animals[4].setBirthDate(LocalDate.of(2016,1,19));
        animalRepository.setAnimals(animals);

        List<AbstractAnimal> expected = Arrays.asList(animals[3]);
        System.out.println(animalRepository.findDuplicate());
        Assertions.assertEquals(expected, animalRepository.findDuplicate());
    }
}
