package com.upgrad.hirewheels.entities;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.persistence.*;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(length = 50, nullable = false)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @Column(length = 50, nullable = false)
    private String password;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(length = 10, nullable = false, unique = true)
    private char mobileNo;

    @Column(length = 10, precision = 2)
    private float walletMoney= 10000.00f;

}