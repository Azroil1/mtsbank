package ru.mtsbank.hw.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Random;

@ConfigurationProperties(prefix = "animal.name")
public class AnimalProperties {



    private String[] fishNames;
    private String[] herbivoresNames;
    private String[] petNames;
    private String[] predatorNames;

    public String getFishNames() {
        return fishNames[new Random().nextInt(fishNames.length)];
    }

    public void setFishNames(String[] fishNames) {
        this.fishNames = fishNames;
    }

    public String getHerbivoresNames() {
        return herbivoresNames[new Random().nextInt(herbivoresNames.length)];
    }

    public void setHerbivoresNames(String[] herbivoresNames) {
        this.herbivoresNames = herbivoresNames;
    }

    public String getPetNames() {
        return petNames[new Random().nextInt(petNames.length)];
    }

    public void setPetNames(String[] petNames) {
        this.petNames = petNames;
    }

    public String getPredatorNames() {
        return predatorNames[new Random().nextInt(predatorNames.length)];
    }

    public void setPredatorNames(String[] predatorNames) {
        this.predatorNames = predatorNames;
    }
}
