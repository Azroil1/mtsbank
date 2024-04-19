package ru.mtsbank.hw.serializers;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import ru.mtsbank.hw.animal.AbstractAnimal;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;


public class ObjectMapperAnimalsForJSON {
    private static final String PATH = "C:\\Users\\Amir\\Desktop\\mts\\src\\main\\resources\\results\\";

    public static void animalCollectionJson(Collection<?> collection, String fileName){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        File file = new File(PATH + fileName);

        try {
            objectMapper.writeValue(file, collection);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void animalMapJson(Map<?,?> map, String fileName){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        File file = new File(PATH + fileName);
        try {
            objectMapper.writeValue(file, map);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static List<AbstractAnimal> readAnimalFromJson(String fileName) throws IOException {
        SimpleModule simpleModule = new SimpleModule("CustomAnimalDeserializer",
                new Version(1,0,0,null,null,null));
        simpleModule.addDeserializer(AbstractAnimal.class, new CustomAnimalDeserializer(AbstractAnimal.class));
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(simpleModule);
        objectMapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES,false);
        File file = new File(PATH + fileName);
        List<AbstractAnimal> abstractAnimalList;
        System.out.println("System start...");
        try {
            abstractAnimalList = objectMapper.readValue(file, new TypeReference<List<AbstractAnimal>>() {});
            System.out.println("I work");
        }catch (IOException e){
            throw new RuntimeException();
        }
        return  abstractAnimalList;
    }
    public static  Map<AbstractAnimal, Integer> readMapAnimalIntegerFromJson(String fileName){
        SimpleModule simpleModule = new SimpleModule("CustomAnimalDeserializer",
                new Version(1,0,0,null,null,null));
        simpleModule.addDeserializer(AbstractAnimal.class, new CustomAnimalDeserializer());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(simpleModule);
        objectMapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES,false);
        File file = new File(PATH + fileName);
        Map<AbstractAnimal, Integer> abstractAnimalIntegerMap;
        System.out.println("readMapAnimalInteger start work");
        try {
            abstractAnimalIntegerMap = objectMapper.readValue(file, new TypeReference<Map<AbstractAnimal, Integer>>() {});
            System.out.println("readMapAnimalInteger work success");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return abstractAnimalIntegerMap;
    }
}
