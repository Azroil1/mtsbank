package test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import ru.mtsbank.hw.animal.AbstractAnimal;
import ru.mtsbank.hw.animalservice.CreateAnimalService;
import ru.mtsbank.hw.animalservice.CreateAnimalServiceImpl;
import ru.mtsbank.hw.searchservise.SearchService;
import ru.mtsbank.hw.searchservise.SearchServiceImpl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


public class SearchServiceImplTests {
    @Mock
    public static AbstractAnimal[] animals;
    @Mock
    public static CreateAnimalService createAnimalService;
    public static SearchService searchService;

    @BeforeAll
    public static void initAnimal(){
        createAnimalService = new CreateAnimalServiceImpl();
        searchService = new SearchServiceImpl();
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
        Assertions.assertArrayEquals(searchService.findLeapYearNames(animals),actual1);
    }

    @ParameterizedTest
    @ValueSource(ints = {7,11})
    @DisplayName("Тест метода findOlderAnimal")
    public void findOlderAnimalTest(int values){
        initAnimal();

        if (values == 7) {
            Assertions.assertArrayEquals(searchService.findOlderAnimal(animals, values), new AbstractAnimal[] {animals[1]});
        } else {
            Assertions.assertArrayEquals(searchService.findOlderAnimal(animals, values), animals);
        }
    }

    @Test
    @DisplayName("Тест метода findDuplicate")
    public void findDuplicate() throws CloneNotSupportedException {
        initAnimal();
        Assertions.assertArrayEquals(searchService.findDuplicate((new AbstractAnimal[]{animals[1], animals[1]})).toArray(), new AbstractAnimal[] {animals[1]});
    }
}
