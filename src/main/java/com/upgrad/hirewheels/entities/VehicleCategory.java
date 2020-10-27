package com.upgrad.hirewheels.entities;

import javax.persistence.*;

@Entity
public class VehicleCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicleCategoryId;

    @Column(length = 50, nullable = false, unique = true)
    private String vehicleCategoryName;

}
