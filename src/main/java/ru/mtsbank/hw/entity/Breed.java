package ru.mtsbank.hw.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "breed")
public class Breed {
    @Id
    @Column(name = "id_breed")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBreed;
    private String breed;
    @OneToMany(mappedBy = "breed")
    private List<Creature> breedCreatures;

    public Breed() {
    }

    public Breed(String breed) {
        this.breed = breed;
    }
}
