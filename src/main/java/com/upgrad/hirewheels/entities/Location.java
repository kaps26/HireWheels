package com.upgrad.hirewheels.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int locationId;

    @Column(length = 50, nullable = false)
    private String locationName;

    @Column(length = 100, nullable = false)
    private String address;

    @Column(length = 6, nullable = false)
    private char pincode;

    @OneToMany(mappedBy = "location")
    private Set<Booking> booking;

    @OneToMany(mappedBy = "location")
    private Set<Vehicle> vehicle;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;


    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getAddress() {
        return address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public char getPincode() {
        return pincode;
    }

    public void setPincode(char pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", locationName='" + locationName + '\'' +
                ", address='" + address + '\'' +
                ", pincode=" + pincode +
                ", city=" + city +
                '}';
    }
}
