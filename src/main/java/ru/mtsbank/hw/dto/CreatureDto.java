package ru.mtsbank.hw.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class CreatureDto {
    private long id;
    private String name;
    private short age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private BreedDto breed;

    public CreatureDto(long id, String name, short age, LocalDate birthDate, BreedDto breed) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
        this.breed = breed;
    }

    public CreatureDto() {}

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

    public BreedDto getBreed() {
        return breed;
    }

    public void setBreed(BreedDto breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "CreatureDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                ", breed=" + breed +
                '}';
    }
}
