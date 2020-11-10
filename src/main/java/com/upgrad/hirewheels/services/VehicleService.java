package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.entities.*;

import java.util.List;

public interface VehicleService {

    List<Vehicle> getAllVehicles();
    List<Vehicle> getVehicleByUserId(Users users);
    List<Vehicle> getAvailableVehicles(VehicleSubcategory vehicleSubcategory, Booking booking);

}
