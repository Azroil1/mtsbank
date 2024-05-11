package ru.mtsbank.hw.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "animal_type")
@Data
public class AnimalType {
    @Id
    @Column(name = "id_type")
    private long id;
    private String type;
    @Column(name = "is_wild")
    private boolean wild;
}
