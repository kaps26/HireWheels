package com.upgrad.hirewheels.entities;

import javax.persistence.*;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicleId;

    @Column(length = 50, nullable = false)
    private String vehicleModel;

    @Column(length = 10, nullable = false)
    private char vehicleNumber;

    @Column(length = 50, nullable = false)
    private String color;

    @Column(length = 1, nullable = false)
    private int availableStatus;

    @Column(length = 500, nullable = false)
    private String vehicleImageUrl;

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public char getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(char vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAvailableStatus() {
        return availableStatus;
    }

    public void setAvailableStatus(int availableStatus) {
        this.availableStatus = availableStatus;
    }

    public String getVehicleImageUrl() {
        return vehicleImageUrl;
    }

    public void setVehicleImageUrl(String vehicleImageUrl) {
        this.vehicleImageUrl = vehicleImageUrl;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", vehicleNumber=" + vehicleNumber +
                ", color='" + color + '\'' +
                ", availableStatus=" + availableStatus +
                ", vehicleImageUrl='" + vehicleImageUrl + '\'' +
                '}';
    }
}

