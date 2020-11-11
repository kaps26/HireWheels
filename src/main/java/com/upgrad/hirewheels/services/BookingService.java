package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.exceptions.InsufficientBalanceException;
import com.upgrad.hirewheels.exceptions.UnauthorizedUserException;
import com.upgrad.hirewheels.exceptions.UserNotRegisteredException;
import org.springframework.stereotype.Service;


public interface BookingService {


    Booking addBooking(Booking booking) throws UserNotRegisteredException, UnauthorizedUserException, InsufficientBalanceException;
}
