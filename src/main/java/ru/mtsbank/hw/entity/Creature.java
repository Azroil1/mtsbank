package ru.mtsbank.hw.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "creature")
public class Creature {
    @Id
    @Column(name = "id_creature")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_creature_sequence")
    @SequenceGenerator(name = "id_creature_sequence", sequenceName = "id_creature_sequence", allocationSize = 1)
    private long id;
    private String name;
    private short age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    @ManyToOne()
    @JoinColumn(name = "type_id", referencedColumnName = "id_type", columnDefinition = "bigint")
    private Breed breed;

    public Creature(String name, short age, LocalDate birthDate, Breed breed) {
        this.breed = breed;
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
    }

    public Creature() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                ", breed=" + breed +
                '}';
    }
}
