package ru.mtsbank.hw.modelsanimalsdatabase;

public class Habitat {
    private long id_area;
    private String area;

    public Habitat(String area, long id_area) {
        this.area = area;
        this.id_area = id_area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public long getId_area() {
        return id_area;
    }

    public void setId_area(long id_area) {
        this.id_area = id_area;
    }

    @Override
    public String toString() {
        return "Habitat{" +
                "id_area=" + id_area +
                ", area='" + area + '\'' +
                '}';
    }
}
