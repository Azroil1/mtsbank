package ru.mtsbank.hw.modelsanimalsdatabase;

import java.time.LocalDate;

public class Creature {
    private int id;
    private String name;
    private int typeId;
    private short age;
    private LocalDate birthDate;

    public Creature(int id, String name, int typeId, short age, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
        this.age = age;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getAge() {
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

    @Override
    public String toString() {
        return "Creature{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeId=" + typeId +
                ", age=" + age +
                ", birthDate=" + birthDate +
                '}';
    }
}
