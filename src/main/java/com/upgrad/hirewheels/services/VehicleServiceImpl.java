package com.upgrad.hirewheels.services;


import com.upgrad.hirewheels.dao.VehicleDao;
import com.upgrad.hirewheels.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleDao vehicleDao;

    @Override
    public Vehicle acceptVehicleDetails(Vehicle vehicle) {
        return vehicleDao.save(vehicle);
    }

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
                vehicle -> vehicle.getAvailableStatus() == 1 && booking.getLocation().equals(vehicle.getLocation())).collect(Collectors.toList());
    }

}
