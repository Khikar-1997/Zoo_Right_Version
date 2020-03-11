package com.example.zoo.rest.model.animal;

import com.example.zoo.persistence.model.AnimalType;
import com.example.zoo.rest.model.cage.CageResponseModel;

import java.util.Objects;

public class AnimalResponseModel {
    private Long id;
    private String name;
    private AnimalType type;
    private CageResponseModel cage;

    public AnimalResponseModel(Long id, String name, AnimalType type, CageResponseModel cage) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.cage = cage;
    }

    public AnimalResponseModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    public CageResponseModel getCage() {
        return cage;
    }

    public void setCage(CageResponseModel cage) {
        this.cage = cage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalResponseModel that = (AnimalResponseModel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                type == that.type &&
                Objects.equals(cage, that.cage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, cage);
    }

    @Override
    public String toString() {
        return "AnimalResponseModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", cage=" + cage +
                '}';
    }
}
