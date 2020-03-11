package com.example.zoo.persistence.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
import java.util.Objects;

@Entity
public class Cage extends AbstractBaseEntity {
    private int cageNumber;

    @Enumerated(EnumType.STRING)
    private CageType type;

    public Cage(Date create_at, int cageNumber, CageType type) {
        super(create_at);
        this.cageNumber = cageNumber;
        this.type = type;
    }

    public Cage() {
    }

    public int getCageNumber() {
        return cageNumber;
    }

    public void setCageNumber(int cageNumber) {
        this.cageNumber = cageNumber;
    }

    public CageType getType() {
        return type;
    }

    public void setType(CageType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cage cage = (Cage) o;
        return cageNumber == cage.cageNumber &&
                type == cage.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cageNumber, type);
    }

    @Override
    public String toString() {
        return "Cage{" +
                "cageNumber=" + cageNumber +
                ", type=" + type +
                '}';
    }
}
