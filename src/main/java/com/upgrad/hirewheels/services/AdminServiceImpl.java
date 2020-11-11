package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.BookingDao;
import com.upgrad.hirewheels.dao.VehicleDao;
import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.exceptions.VehicleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminService adminService;

    @Qualifier("vehicleDao")
    @Autowired
    VehicleDao vehicleDao;

    @Qualifier("bookingDao")
    @Autowired
    BookingDao bookingDao;

    @Override
    public Vehicle registerVehicle(Vehicle vehicle) {
        vehicle.setAvailabilityStatus(1);
        return vehicleDao.save(vehicle);
    }
    @Override
    public Vehicle getVehicleDetails(int id) throws VehicleNotFoundException {
        return vehicleDao.findById(id)
                .orElseThrow(
                        () -> new VehicleNotFoundException("Vehicle not found for id: " + id)
                );
    }

    @Override
    public Vehicle changeAvailabilty(int id) throws VehicleNotFoundException {

        Vehicle savedVehicle=getVehicleDetails(id);
        if (savedVehicle.getAvailabilityStatus() == 0) {
            savedVehicle.setAvailabilityStatus(1);
        }
        else {
            savedVehicle.setAvailabilityStatus(0);
        }
        return vehicleDao.save(savedVehicle);
    }

    @Override
    public Vehicle acceptVehicleDetails(Vehicle vehicle) {
        return vehicleDao.save(vehicle);
    }

    @Override
    public Booking acceptBookingDetails(Booking booking) {
        return bookingDao.save(booking);
    }

}
