package com.example.zoo.rest.model.cage;

import com.example.zoo.persistence.model.CageType;

import java.util.Date;
import java.util.Objects;

public class CageResponseModel {
    private Long id;
    private int cageNumber;
    private CageType type;
    private Date createAt;

    public CageResponseModel(Long id, int cageNumber, CageType type, Date createAt) {
        this.id = id;
        this.cageNumber = cageNumber;
        this.type = type;
        this.createAt = createAt;
    }

    public CageResponseModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public void setType(CageType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CageResponseModel that = (CageResponseModel) o;
        return cageNumber == that.cageNumber &&
                Objects.equals(id, that.id) &&
                type == that.type &&
                Objects.equals(createAt, that.createAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cageNumber, type, createAt);
    }

    @Override
    public String toString() {
        return "CageResponseModel{" +
                "id=" + id +
                ", cageNumber=" + cageNumber +
                ", type=" + type +
                ", createAt=" + createAt +
                '}';
    }
}
