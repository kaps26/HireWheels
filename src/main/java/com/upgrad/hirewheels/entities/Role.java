package com.upgrad.hirewheels.entities;

import javax.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roleId;

    @Column(length = 50, nullable = false, unique = true)
    private String roleName;
}
