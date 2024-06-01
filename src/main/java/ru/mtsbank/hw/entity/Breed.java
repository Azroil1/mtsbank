package ru.mtsbank.hw.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "animal_type")
public class Breed {
    @Id
    @Column(name = "id_type")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_type_sequence")
    @SequenceGenerator(name = "id_type_sequence", sequenceName = "id_type_sequence", allocationSize = 1)
    private long idBreed;
    @Column(name = "type", columnDefinition = "VARCHAR(50)")
    private String type;
    @OneToMany(mappedBy = "breed")
    private List<Creature> breedCreatures;

    public Breed() {
    }

    public Breed(long idBreed, String type, List<Creature> breedCreatures) {
        this.idBreed = idBreed;
        this.type = type;
        this.breedCreatures = breedCreatures;
    }

    public Breed(String type, List<Creature> breedCreatures) {
        this.type = type;
        this.breedCreatures = breedCreatures;
    }

    public Breed(String type) {
        this.type = type;
    }

    public long getIdBreed() {
        return idBreed;
    }

    public void setIdBreed(long idBreed) {
        this.idBreed = idBreed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Creature> getBreedCreatures() {
        return breedCreatures;
    }

    public void setBreedCreatures(List<Creature> breedCreatures) {
        this.breedCreatures = breedCreatures;
    }

    @Override
    public String toString() {
        return "Breed{" +
                "breed='" + type + '\'' +
                '}';
    }
}
