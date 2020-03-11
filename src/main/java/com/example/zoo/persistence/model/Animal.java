package com.example.zoo.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Animal extends AbstractBaseEntity {
    private String name;

    @Enumerated(EnumType.STRING)
    private AnimalType type;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "cage_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Cage cage;

    public Animal(String name, AnimalType type, Cage cage) {
        this.name = name;
        this.type = type;
        this.cage = cage;
    }

    public Animal() {
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

    public Cage getCage() {
        return cage;
    }

    public void setCage(Cage cage) {
        this.cage = cage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name) &&
                type == animal.type &&
                Objects.equals(cage, animal.cage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, type, cage);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", cage=" + cage +
                '}';
    }
}
