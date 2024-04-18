package ru.mtsbank.hw.serializers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import ru.mtsbank.hw.animal.AbstractAnimal;
import ru.mtsbank.hw.animal.fish.models.GoldFish;
import ru.mtsbank.hw.animal.herbivores.models.Cow;
import ru.mtsbank.hw.animal.pet.models.Cat;
import ru.mtsbank.hw.animal.predator.models.Wolf;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

public class CustomAnimalDeserializer extends StdDeserializer<AbstractAnimal> {

    public CustomAnimalDeserializer(){
        this(null);
    }
    public CustomAnimalDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public AbstractAnimal deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        ObjectCodec codec = p.getCodec();
        JsonNode jsonNode = codec.readTree(p);

        String bread = jsonNode.get("breed").asText();
        String name = jsonNode.get("name").asText();
        BigDecimal cost = jsonNode.get("cost").decimalValue();
        String character = jsonNode.get("character").asText();
        LocalDate birthDate = LocalDate.parse(jsonNode.get("birthDate").asText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String animalType = jsonNode.get("animalType").asText();
        String secretInfo = new String(Base64.getDecoder().decode(jsonNode.get("secretInformation").asText()));
        AbstractAnimal animal;
        switch (animalType){
            case "CAT":
               animal = new Cat(bread,name,cost,character);
               break;

            case "GOLDFISH":
                animal = new GoldFish(bread,name,cost,character);
                break;

            case "COW" :
                animal = new Cow(bread,name,cost,character);
                break;
            default:
                animal = new Wolf(bread,name,character);
                break;
        }
        animal.setBirthDate(birthDate);
        animal.setSecretInformation(secretInfo);
        return animal;
    }
}
