package ru.mtsbank.hw.dto;

import java.util.List;

public class BreedDto {
    private long idBreed;
    private String type;
    private List<CreatureDto> creatures;

    public BreedDto() {
    }

    public BreedDto(long idBreed, String type, List<CreatureDto> creatures) {
        this.idBreed = idBreed;
        this.type = type;
        this.creatures = creatures;
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

    public List<CreatureDto> getCreatures() {
        return creatures;
    }

    public void setCreatures(List<CreatureDto> creatures) {
        this.creatures = creatures;
    }

    @Override
    public String toString() {
        return "BreedDto{" +
                ", type='" + type + '\'' +
                '}';
    }
}
