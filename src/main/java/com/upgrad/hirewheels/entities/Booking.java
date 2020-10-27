package com.upgrad.hirewheels.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Scanner;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingId;

    @Column(nullable = false)
    private LocalDateTime pickUpDate;

    @Column(nullable = false)
    private LocalDateTime dropOffDate;

    @Column(nullable = false)
    private LocalDateTime bookingDate;

    @Column(length = 10, precision = 2, nullable = false)
    private float amount;
}
