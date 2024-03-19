package ru.mtsbank.hw;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.mtsbank.hw.Application;
import ru.mtsbank.hw.animal.AbstractAnimal;
import ru.mtsbank.hw.animal.fish.models.Barbus;
import ru.mtsbank.hw.animal.herbivores.models.Cow;
import ru.mtsbank.hw.animal.pet.models.Cat;
import ru.mtsbank.hw.animal.pet.models.Dog;
import ru.mtsbank.hw.animalservice.CreateAnimalService;
import ru.mtsbank.hw.animalservice.CreateAnimalServiceImpl;
import ru.mtsbank.hw.animalsrepository.AnimalRepositoryImpl;
import ru.mtsbank.hw.config.AnimalProperties;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import static org.mockito.Mockito.when;


@SpringBootTest
public class AnimalRepositoryImplTests {
    @Mock
    public static CreateAnimalServiceImpl createAnimalService;

    @Mock
    public  static AnimalProperties animalProperties;

    @MockBean
    public static AnimalRepositoryImpl animalRepository;


    @BeforeAll
    public static void setup() {
        Map<String,List<AbstractAnimal>> stringListHashMap = new HashMap<>();
        List<AbstractAnimal> dog = new ArrayList<>();
        dog.add(new Dog("fe", "ed", new BigDecimal(213.3), "fdf"));
        dog.get(0).setBirthDate(LocalDate.of(2015,4,20));
        dog.add(new Dog("fe", "ed", new BigDecimal(213.3), "fdf"));
        dog.get(1).setBirthDate(LocalDate.of(2016,4,20));
        dog.add(new Dog("fe", "ed", new BigDecimal(213.3), "fdf"));
        dog.get(2).setBirthDate(LocalDate.of(2015,4,20));
        stringListHashMap.put("Dog", dog);
        stringListHashMap.put("Cat",List.of(new Cat("fe", "ed", new BigDecimal(213.3), "fdf")));
        stringListHashMap.get("Cat").get(0).setBirthDate(LocalDate.of(2013,5,15));

        createAnimalService.setAnimalMap(stringListHashMap);

    }

    @Test
    @DisplayName("Тест метода findLeapYears()")
    public void findLeapYearsTest() {
        Map<String,LocalDate> stringLocalDateMap= new HashMap<>();
        stringLocalDateMap.put("Dog ed", LocalDate.of(2016,4,20));
        when(animalRepository.findLeapYearNames()).thenCallRealMethod();
        Assertions.assertEquals(animalRepository.findLeapYearNames(),stringLocalDateMap);
    }

    @ParameterizedTest
    @ValueSource(ints = {8, 30})
    @DisplayName("Тест метода findOlderAnimal")
    public void findOlderAnimalTest(int values) {
        when(animalRepository.findOlderAnimal(values)).thenCallRealMethod();
        // Ожидаемый результат для метода findOlderAnimal()
        if (values == 8) {
            AbstractAnimal animal = new Dog("fe", "ed", new BigDecimal(213.3), "fdf");
            animal.setBirthDate(LocalDate.of(2016,4,20));
            Map<AbstractAnimal,LocalDate> animalIntegerMap = new HashMap<>();
            animalIntegerMap.put(animal,animal.getBirthDate());
            animalRepository.findOlderAnimal(values);
            Assertions.assertEquals(animalRepository.findOlderAnimal(values), animalIntegerMap);
        } else {
            AbstractAnimal animal = new Cat("fe", "ed", new BigDecimal(213.3), "fdf");
            animal.setBirthDate(LocalDate.of(2013,5,15));
            Map<AbstractAnimal,LocalDate> animalIntegerMap = new HashMap<>();
            animalIntegerMap.put(animal,animal.getBirthDate());
            Assertions.assertEquals(animalRepository.findOlderAnimal(values), animalIntegerMap);
        }
    }

    @Test
    @DisplayName("Тест метода findDuplicate")
    public void findDuplicate() {
        when(animalRepository.findDuplicate()).thenCallRealMethod();
        Map<String,Integer> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put("Dog", 1);
        System.out.println(createAnimalService.getAnimalMap());
        Assertions.assertEquals(animalRepository.findDuplicate(), stringIntegerMap);
    }
}
