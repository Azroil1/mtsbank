package ru.mtsbank.hw.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class AnimalHabitatID implements Serializable {
    private long idAnimalType;
    private long idArea;

    public AnimalHabitatID(long idAnimalType, long idArea) {
        this.idAnimalType = idAnimalType;
        this.idArea = idArea;
    }

}
