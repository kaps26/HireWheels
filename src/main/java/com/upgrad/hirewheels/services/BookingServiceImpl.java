package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.BookingDao;
import com.upgrad.hirewheels.dao.UsersDao;
import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.entities.Users;
import com.upgrad.hirewheels.exceptions.InsufficientBalanceException;
import com.upgrad.hirewheels.exceptions.UnauthorizedUserException;
import com.upgrad.hirewheels.exceptions.UserNotRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private UserService userService;

    @Autowired
    private BookingDao bookingDao;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private UsersDao usersDao;

    @Override
    public Booking addBooking(Booking booking) throws UserNotRegisteredException, UnauthorizedUserException, InsufficientBalanceException {
        Users users  = userService.getUsers(booking.getUsers());
        if (users.getWalletMoney() < booking.getAmount()) {
            throw new InsufficientBalanceException("Insufficient balance");
        } else {
            Booking bookingMade = bookingDao.save(booking);
            users.setWalletMoney((float)(users.getWalletMoney() - booking.getAmount()));
            usersDao.save(users);
            return bookingMade;
        }
    }
}
