package com.upgrad.hirewheels.entities;

import javax.persistence.*;

@Entity
public class VehicleSubcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicleSubcategoryId;

    @Column(length = 50, nullable = false, unique = true)
    private String vehicleSubcategoryName;

    @Column(length = 10, precision = 2, nullable = false)
    private float pricePerDay;

    public int getVehicleSubcategoryId() {
        return vehicleSubcategoryId;
    }

    public void setVehicleSubcategoryId(int vehicleSubcategoryId) {
        this.vehicleSubcategoryId = vehicleSubcategoryId;
    }

    public String getVehicleSubcategoryName() {
        return vehicleSubcategoryName;
    }

    public void setVehicleSubcategoryName(String vehicleSubcategoryName) {
        this.vehicleSubcategoryName = vehicleSubcategoryName;
    }

    public float getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(float pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    @Override
    public String toString() {
        return "VehicleSubcategory{" +
                "vehicleSubcategoryId=" + vehicleSubcategoryId +
                ", vehicleSubcategoryName='" + vehicleSubcategoryName + '\'' +
                ", pricePerDay=" + pricePerDay +
                '}';
    }
}
