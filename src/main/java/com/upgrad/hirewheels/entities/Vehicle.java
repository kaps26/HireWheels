package com.upgrad.hirewheels.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int vehicleId;

    @Column(length = 50, nullable = false)
    private String vehicleModel;

    @Column(length = 10, nullable = false)
    private String vehicleNumber;

    @Column(length = 50, nullable = false)
    private String color;

    @Column(length = 1, nullable = false)
    private int availableStatus;

    @Column(length = 500, nullable = false)
    private String vehicleImageUrl;

    @OneToMany(mappedBy = "vehicle",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Booking> booking;

    @ManyToOne
    @JoinColumn(name = "fuelType_id", nullable = false)
    private FuelType fuelType;

    public Set<Booking> getBooking() {
        return booking;
    }

    public void setBooking(Set<Booking> booking) {
        this.booking = booking;
    }

    @ManyToOne
    @JoinColumn(name= "location_id", nullable = false)
    private Location location;

    @ManyToOne
    @JoinColumn(name = "vehicleSubcategory_id", nullable = false)
    private VehicleSubcategory vehicleSubcategory;

    public Vehicle() {
    }

    public Vehicle(String vehicleModel, String vehicleNumber, VehicleSubcategory vehicleSubcategory, String color, Location location, FuelType fuelType, int availabilityStatus, String vehicleImageUrl) {
        this.vehicleModel = vehicleModel;
        this.vehicleNumber = vehicleNumber;
        this.vehicleSubcategory = vehicleSubcategory;
        this.color = color;
        this.location = location;
        this.fuelType = fuelType;
        this.availableStatus = availabilityStatus;
        this.vehicleImageUrl = vehicleImageUrl;
    }

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

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
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

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public VehicleSubcategory getVehicleSubcategory() {
        return vehicleSubcategory;
    }

    public void setVehicleSubcategory(VehicleSubcategory vehicleSubcategory) {
        this.vehicleSubcategory = vehicleSubcategory;
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
                ", fuelType=" + fuelType +
                ", location=" + location +
                ", vehicleSubcategory=" + vehicleSubcategory +
                '}';
    }

}

