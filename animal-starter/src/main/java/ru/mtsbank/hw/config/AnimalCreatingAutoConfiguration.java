package ru.mtsbank.hw.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.mtsbank.hw.animal.AbstractAnimal;
import ru.mtsbank.hw.animalservice.CreateAnimalServiceImpl;

@Configuration
@EnableConfigurationProperties(AnimalProperties.class)
public class AnimalCreatingAutoConfiguration {
    @Bean
    @Scope("prototype")
    CreateAnimalServiceImpl createAnimalService(AnimalProperties properties){
        return new CreateAnimalServiceImpl(properties);
    }

}
