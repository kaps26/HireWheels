package com.upgrad.hirewheels.entities;

import javax.persistence.*;

@Entity
public class FuelType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int fuelTypeId;

    @Column(length = 50, nullable = false, unique = true)
    private String fuelTypeName;

    public int getFuelTypeId() {
        return fuelTypeId;
    }

    public void setFuelTypeId(int fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public String getFuelTypeName() {
        return fuelTypeName;
    }

    public void setFuelTypeName(String fuelTypeName) {
        this.fuelTypeName = fuelTypeName;
    }

    @Override
    public String toString() {
        return "FuelType{" +
                "fuelTypeId=" + fuelTypeId +
                ", fuelTypeName='" + fuelTypeName + '\'' +
                '}';
    }
}
