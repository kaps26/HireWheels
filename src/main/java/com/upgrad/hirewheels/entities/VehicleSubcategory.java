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
}
