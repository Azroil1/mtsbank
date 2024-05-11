package ru.mtsbank.hw.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class AnimalProviderID implements Serializable {
    private int idAnimalType;
    private int idProvider;

    public AnimalProviderID(int idAnimalType, int idProvider) {
        this.idAnimalType = idAnimalType;
        this.idProvider = idProvider;
    }
}
