package com.upgrad.hirewheels.dto;

import com.upgrad.hirewheels.entities.Location;
import com.upgrad.hirewheels.entities.Users;
import com.upgrad.hirewheels.entities.Vehicle;

public class BookingDTO {

    private int bookingId;
    private int pickupDate;
    private int dropoffDate;
    private int bookingDate;
    private float amount;
    private Location location;
    private Vehicle vehicle;
    private Users user;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(int pickupDate) {
        this.pickupDate = pickupDate;
    }

    public int getDropoffDate() {
        return dropoffDate;
    }

    public void setDropoffDate(int dropoffDate) {
        this.dropoffDate = dropoffDate;
    }

    public int getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(int bookingDate) {
        this.bookingDate = bookingDate;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

}
