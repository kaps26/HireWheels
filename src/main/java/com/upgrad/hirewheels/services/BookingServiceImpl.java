package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.BookingDao;
import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.exceptions.BookingDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingService bookingService;

    @Qualifier("bookingDao")
    @Autowired
    BookingDao bookingDao;

    @Override
    public Booking addBooking(Booking booking) throws BookingDetailsNotFoundException {
        if (booking.getUser().getWalletMoney() < booking.getVehicle().getVehicleSubcategory().getPricePerDay()) {
            throw new BookingDetailsNotFoundException("Insufficient Balance.Please check with Admin");
        } else {
            booking.getUser().setWalletMoney(booking.getUser().getWalletMoney() - booking.getVehicle().getVehicleSubcategory().getPricePerDay());
            return bookingDao.save(booking);
        }
    }
}
