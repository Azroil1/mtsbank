package ru.mtsbank.hw.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@IdClass(AnimalProviderID.class)
@Table(name = "animals_provider")
public class AnimalProvider {
    @Id
    @Column(name = "id_animal_type")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAnimalProvider;
    @Id
    @Column(name = "id_provider")
    private int idProvider;
}
