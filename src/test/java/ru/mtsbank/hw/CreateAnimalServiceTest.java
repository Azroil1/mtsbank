package ru.mtsbank.hw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import ru.mtsbank.hw.animalservice.AnimalTypes;
import ru.mtsbank.hw.animalservice.CreateAnimalServiceImpl;
import ru.mtsbank.hw.config.AnimalProperties;



@SpringBootTest
public class CreateAnimalServiceTest {

    @Autowired
    CreateAnimalServiceImpl createAnimalService;

    @Autowired
    AnimalProperties animalProperties;

    @Test
    public void testAnimalName(){
        createAnimalService.setTypes(AnimalTypes.BARBUS);
        animalProperties.setFishNames(new String[] {"Fish12"});
        Assertions.assertEquals(createAnimalService.createAnimal().getName(),"Fish12");
    }

    @Test
    public void testAnimalNotNull(){
        Assertions.assertNotNull(createAnimalService.createAnimal());
    }
}
