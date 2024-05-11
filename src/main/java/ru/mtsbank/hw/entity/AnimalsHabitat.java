package ru.mtsbank.hw.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "animals_habits")
@IdClass(AnimalHabitatID.class)
@Data
public class AnimalsHabitat {
    @Id
    @Column(name = "id_animal_type")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAnimalType;
    @Id
    @Column(name = "id_area")
    private long idArea;
}
