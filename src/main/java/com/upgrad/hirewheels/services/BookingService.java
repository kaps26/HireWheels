package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.exceptions.*;
import org.springframework.stereotype.Service;

@Service
public interface BookingService {
    public Booking addBooking(Booking booking) throws BookingDetailsNotFoundException, InsufficientBalanceException, UnauthorizedUserException, VehicleNotFoundException, APIException;
}
