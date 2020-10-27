package com.upgrad.hirewheels.entities;

import javax.persistence.*;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cityId;

    @Column(length = 50, nullable = false)
    private String cityName;

}