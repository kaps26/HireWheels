package com.upgrad.hirewheels.entities;

import javax.persistence.*;

@Entity
public class FuelType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int fuelTypeId;

    @Column(length = 50, nullable = false, unique = true)
    private String fuelTypeName;

}
