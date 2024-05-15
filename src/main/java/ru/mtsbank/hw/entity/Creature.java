package ru.mtsbank.hw.entity;


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
    @Column(name = "type_id")
    private int typeId;
    private short age;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id", insertable = false, updatable = false)
    private Breed breed;

    public Creature(String name, int typeId, short age, LocalDate birthDate, Breed breed) {
        this.breed = breed;
        this.name = name;
        this.typeId = typeId;
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
                ", typeId=" + typeId +
                ", age=" + age +
                ", birthDate=" + birthDate +
                ", breed=" + breed +
                '}';
    }
}
