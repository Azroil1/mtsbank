package ru.mtsbank.hw.entity;

import javax.persistence.*;

@Entity
@Table(name = "provider")
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_provider;
    private String name;
    @Column(name = "phone")
    private String phone_number;

    public Provider(int id_provider, String name, String phone_number) {
        this.id_provider = id_provider;
        this.name = name;
        this.phone_number = phone_number;
    }

    public Provider() {

    }

    public int getId_provider() {
        return id_provider;
    }

    public void setId_provider(int id_provider) {
        this.id_provider = id_provider;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "id_provider=" + id_provider +
                ", name='" + name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}
