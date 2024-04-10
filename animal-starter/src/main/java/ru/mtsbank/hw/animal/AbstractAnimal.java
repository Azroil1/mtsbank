package ru.mtsbank.hw.animal;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;


public abstract class AbstractAnimal implements Animal {
    protected String breed;
    protected String name;
    protected BigDecimal cost;
    protected String character;
    protected LocalDate birthDate;
    private String animalType;

    public AbstractAnimal(String breed, String name, BigDecimal cost, String character) {
        this.breed = breed;
        this.name = name;
        this.cost= cost.setScale(2,RoundingMode.DOWN);
        this.character = character;
        this.birthDate = randomDate();
    }


    public AbstractAnimal(String breed, String name, String character) {
        this.breed = breed;
        this.name = name;
        this.character = character;
        this.birthDate = randomDate();
    }

    private LocalDate randomDate(){
        long betweenDays = ChronoUnit.DAYS.between(LocalDate.of(1900,1,1),
                LocalDate.now());
        long random = ThreadLocalRandom.current().nextLong(betweenDays);
        return LocalDate.of(1900,1,1).plusDays(random);
    }

    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getCost() {
        return cost;
    }

    @Override
    public String getCharacter() {
        return character;
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractAnimal that = (AbstractAnimal) o;
        return Objects.equals(breed, that.breed) && Objects.equals(name, that.name)
                && Objects.equals(cost, that.cost) && Objects.equals(character, that.character)
                && Objects.equals(birthDate,that.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(breed, name, cost, character, birthDate);
    }

    @Override
    public String toString() {
        return "AbstractAnimal{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                ", birthDate=" + birthDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) +
                '}';
    }
}
