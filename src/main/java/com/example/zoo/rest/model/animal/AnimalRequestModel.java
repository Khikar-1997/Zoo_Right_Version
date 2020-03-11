package com.example.zoo.rest.model.animal;

import com.example.zoo.persistence.model.AnimalType;

import java.util.Objects;

public class AnimalRequestModel{
    private String name;
    private AnimalType type;
    private Long cageId;

    public AnimalRequestModel(String name, AnimalType type, Long cageId) {
        this.name = name;
        this.type = type;
        this.cageId = cageId;
    }

    public AnimalRequestModel() {
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

    public Long getCageId() {
        return cageId;
    }

    public void setCageId(Long cageId) {
        this.cageId = cageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalRequestModel that = (AnimalRequestModel) o;
        return Objects.equals(name, that.name) &&
                type == that.type &&
                Objects.equals(cageId, that.cageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, cageId);
    }

    @Override
    public String toString() {
        return "AnimalRequestModel{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", cageId=" + cageId +
                '}';
    }
}
