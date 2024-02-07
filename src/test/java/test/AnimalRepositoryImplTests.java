package test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import ru.mtsbank.hw.animal.AbstractAnimal;
import ru.mtsbank.hw.animalservice.CreateAnimalService;
import ru.mtsbank.hw.animalservice.CreateAnimalServiceImpl;
import ru.mtsbank.hw.animalsrepository.AnimalRepository;
import ru.mtsbank.hw.animalsrepository.AnimalRepositoryImpl;

import java.time.LocalDate;


public class AnimalRepositoryImplTests {
    @Mock
    public static AbstractAnimal[] animals;
    @Mock
    public static CreateAnimalService createAnimalService;
    @Mock
    public static AnimalRepository animalRepository;

    @BeforeAll
    public static void initAnimal(){
        createAnimalService = new CreateAnimalServiceImpl();
        animalRepository = new AnimalRepositoryImpl();
        animals = createAnimalService.checkTypeAnimal(5);
        animals[0].setBirthDate(LocalDate.of(2015,4,20));
        animals[1].setBirthDate(LocalDate.of(2017,10,23));
        animals[2].setBirthDate(LocalDate.of(2016,11,13));
        animals[3].setBirthDate(LocalDate.of(2013,5,16));
        animals[4].setBirthDate(LocalDate.of(2016,1,19));
    }


    @Test
    @DisplayName("Тест метода findLeapYears()")
    public void findLeapYearsTest(){
        initAnimal();
        AbstractAnimal[] actual1 = new AbstractAnimal[] {animals[2],animals[4]};
        System.out.println(animalRepository.findLeapYearNames(animals));
        Assertions.assertArrayEquals(animalRepository.findLeapYearNames(animals),actual1);
    }

    @ParameterizedTest
    @ValueSource(ints = {7,11})
    @DisplayName("Тест метода findOlderAnimal")
    public void findOlderAnimalTest(int values){
        initAnimal();

        if (values == 7) {
            Assertions.assertArrayEquals(animalRepository.findOlderAnimal(animals, values), new AbstractAnimal[] {animals[1]});
        } else {
            Assertions.assertArrayEquals(animalRepository.findOlderAnimal(animals, values), animals);
        }
    }

    @Test
    @DisplayName("Тест метода findDuplicate")
    public void findDuplicate() throws CloneNotSupportedException {
        initAnimal();
        Assertions.assertArrayEquals(animalRepository.findDuplicate((new AbstractAnimal[]{animals[1], animals[1],animals[1],animals[2],animals[2]})).toArray(),
                new AbstractAnimal[] {animals[1],animals[2]});
    }
}
