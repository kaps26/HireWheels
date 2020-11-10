package com.upgrad.hirewheels.services;


import com.upgrad.hirewheels.dao.VehicleDao;
import com.upgrad.hirewheels.entities.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleDao vehicleDao;

    @Autowired

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleDao.findAll();
    }

    @Override
    public List<Vehicle> getVehicleByUserId(Users users) {
        return null;
    }


    @Override
    public List<Vehicle> getAvailableVehicles(VehicleSubcategory vehicleSubcategory, Booking booking) {
        List<Vehicle> vehicles = vehicleDao.findByVehicleSubcategory(vehicleSubcategory);
        return vehicles.stream().filter(
                vehicle ->
                        vehicle.getAvailableStatus() == 1
                                && booking.getLocation().equals(vehicle.getLocation())
        ).collect(Collectors.toList());
    }
}
