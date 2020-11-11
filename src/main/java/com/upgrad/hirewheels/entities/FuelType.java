package com.upgrad.hirewheels.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class FuelType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int fuelTypeId;

    @Column(length = 50, nullable = false, unique = true)
    private String fuelTypeName;

    @OneToMany(mappedBy = "fuelType",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Vehicle> vehicle;

    public FuelType(int fuelTypeId, String fuelTypeName) {
        this.fuelTypeId = fuelTypeId;
        this.fuelTypeName = fuelTypeName;
    }

    public FuelType() {
    }

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
