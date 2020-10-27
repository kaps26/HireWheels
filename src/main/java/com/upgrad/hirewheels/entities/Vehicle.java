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
}

