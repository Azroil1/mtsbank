package ru.mtsbank.hw.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "animals_provider")
public class AnimalProvider {
    @EmbeddedId
    private AnimalProviderID animalProviderID;
}
