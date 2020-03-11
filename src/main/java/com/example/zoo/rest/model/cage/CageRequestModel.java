package com.example.zoo.rest.model.cage;

import com.example.zoo.persistence.model.CageType;

import java.util.Objects;

public class CageRequestModel {
    private int cageNumber;
    private CageType type;

    public CageRequestModel(int cageNumber, CageType type) {
        this.cageNumber = cageNumber;
        this.type = type;
    }

    public CageRequestModel() {
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
        CageRequestModel that = (CageRequestModel) o;
        return cageNumber == that.cageNumber &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cageNumber, type);
    }

    @Override
    public String toString() {
        return "CageRequestModel{" +
                "cageNumber=" + cageNumber +
                ", type=" + type +
                '}';
    }
}
