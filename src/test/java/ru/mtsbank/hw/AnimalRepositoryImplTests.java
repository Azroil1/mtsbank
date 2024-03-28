package ru.mtsbank.hw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import ru.mtsbank.hw.animal.AbstractAnimal;
import ru.mtsbank.hw.animal.pet.models.Cat;
import ru.mtsbank.hw.animal.pet.models.Dog;
import ru.mtsbank.hw.animal.predator.models.Wolf;
import ru.mtsbank.hw.animalservice.CreateAnimalServiceImpl;
import ru.mtsbank.hw.animalsrepository.AnimalRepositoryImpl;
import ru.mtsbank.hw.exceptions.SizeAnimalListException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

@SpringBootTest
public class AnimalRepositoryImplTests {

    @Mock
    private CreateAnimalServiceImpl createAnimalService;

    @InjectMocks
    private AnimalRepositoryImpl animalRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        Map<String,List<AbstractAnimal>> stringListHashMap = new HashMap<>();
        List<AbstractAnimal> dogList = new ArrayList<>();
        dogList.add(new Dog("fe", "ed", new BigDecimal(213.3), "fdf"));
        dogList.get(0).setBirthDate(LocalDate.of(2015, 4, 20));
        dogList.add(new Dog("fe", "ed", new BigDecimal(213.3), "fdf"));
        dogList.get(1).setBirthDate(LocalDate.of(2016, 4, 20));
        dogList.add(new Dog("fe", "ed", new BigDecimal(213.3), "fdf"));
        dogList.get(2).setBirthDate(LocalDate.of(2015, 4, 20));
        stringListHashMap.put("Dog", dogList);
        stringListHashMap.put("Cat", List.of(new Cat("fe", "ed", new BigDecimal(213.3), "fdf")));
        stringListHashMap.get("Cat").get(0).setBirthDate(LocalDate.of(2013, 5, 15));

        when(createAnimalService.getAnimalMap()).thenReturn(stringListHashMap);
    }
    @Test
    @DisplayName("Тест метода findLeapYears()")
    public void findLeapYearsTest() {
        Map<String, LocalDate> expectedMap = new HashMap<>();
        expectedMap.put("ed", LocalDate.of(2016, 4, 20));
        Assertions.assertEquals(expectedMap, animalRepository.findLeapYearNames());
    }
    @ParameterizedTest
    @ValueSource(ints = {8, 30})
    @DisplayName("Тест метода findOlderAnimal")
    public void findOlderAnimalTest(int years) {
        Map<AbstractAnimal, LocalDate> expectedMap = new HashMap<>();
        LocalDate birthDate = years == 8 ? LocalDate.of(2016, 4, 20) : LocalDate.of(2013, 5, 15);
        expectedMap.put(new Dog("fe", "ed", new BigDecimal(213.3), "fdf"), birthDate);
        Assertions.assertEquals(expectedMap, animalRepository.findOlderAnimal(years));
    }

    @Test
    @DisplayName("Тест метода findDuplicate")
    public void findDuplicate() {
        Map<String,List<AbstractAnimal>> expectedMap = new HashMap<>();
        expectedMap.put("Dog", List.of(new Dog("fe", "ed", new BigDecimal(213.3), "fdf")));
        expectedMap.get("Dog").get(0).setBirthDate(LocalDate.of(2015, 4, 20));
        Assertions.assertEquals(expectedMap, animalRepository.findDuplicate());
    }

    @Test
    @DisplayName("Тест метода findAverageAge")
    public void findAverageAge(){
        List<AbstractAnimal> abstractAnimalList = new ArrayList<>();
        abstractAnimalList.add(new Dog("fe", "ed", new BigDecimal(3), "fdf"));
        abstractAnimalList.get(0).setBirthDate(LocalDate.of(2015,4,20));
        abstractAnimalList.add(new Dog("fe", "ed", new BigDecimal(1), "fdf"));
        abstractAnimalList.get(1).setBirthDate(LocalDate.of(2016,4,20));
        abstractAnimalList.add(new Dog("fe", "ed", new BigDecimal(3), "fdf"));
        abstractAnimalList.get(2).setBirthDate(LocalDate.of(2015,4,20));
        abstractAnimalList.add(new Wolf("ds", "ds", "df"));
        abstractAnimalList.get(3).setBirthDate(LocalDate.of(2020, 4, 20));

        double expectedAverageAge = 7.5;
        Assertions.assertEquals(expectedAverageAge, animalRepository.findAverageAge(abstractAnimalList));
    }

    @Test
    @DisplayName("Тест метода findOldExpensive")
    public void findOldExpensive(){
        List<AbstractAnimal> abstractAnimalList = new ArrayList<>();
        abstractAnimalList.add(new Dog("fe", "ed", new BigDecimal(3), "fdf"));
        abstractAnimalList.get(0).setBirthDate(LocalDate.of(2015,4,20));
        abstractAnimalList.add(new Dog("fe", "ed", new BigDecimal(3), "fdf"));
        abstractAnimalList.get(1).setBirthDate(LocalDate.of(2015,4,20));
        List<AbstractAnimal> expectedList = new ArrayList<>();
        Assertions.assertEquals(expectedList, animalRepository.findOldExpensive(abstractAnimalList));
    }

    @Test
    @DisplayName("Тест метода findOlderAnimal на исключения ")
    public void finOlderAnimal(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> animalRepository.findOlderAnimal(-10));
    }
    @Test
    @DisplayName("Ппк")
    public void findMinCostAnimal() throws SizeAnimalListException {
        Map<String,List<AbstractAnimal>> map = new HashMap<>();
        map.put("LION", new ArrayList<>());
        when(createAnimalService.getAnimalMap()).thenReturn(map);
        Assertions.assertThrows(SizeAnimalListException.class, () -> animalRepository.findMinCostAnimals());
    }


}
