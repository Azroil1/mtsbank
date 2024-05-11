package ru.mtsbank.hw.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import ru.mtsbank.hw.animalservice.AnimalTypes;
import ru.mtsbank.hw.animalservice.CreateAnimalServiceImpl;

import java.util.Random;

@Configuration
public class BeanPostProcessorCreateAnimalService implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof CreateAnimalServiceImpl) {
            CreateAnimalServiceImpl createAnimalService = (CreateAnimalServiceImpl) bean;
            createAnimalService.setTypes(AnimalTypes.values()[new Random().nextInt(AnimalTypes.values().length)]);
            return bean;
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
