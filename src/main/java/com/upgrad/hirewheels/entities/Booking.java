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

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDateTime getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDateTime pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public LocalDateTime getDropOffDate() {
        return dropOffDate;
    }

    public void setDropOffDate(LocalDateTime dropOffDate) {
        this.dropOffDate = dropOffDate;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", pickUpDate=" + pickUpDate +
                ", dropOffDate=" + dropOffDate +
                ", bookingDate=" + bookingDate +
                ", amount=" + amount +
                '}';
    }
}
