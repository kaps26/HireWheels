package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.entities.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface VehicleService {

    public Vehicle acceptVehicleDetails(Vehicle vehicle);
    List<Vehicle> getAllVehicles();
    List<Vehicle> getVehicleByUserId(Users users);
    List<Vehicle> getAvailableVehicles(VehicleSubcategory vehicleSubcategory, Booking booking);

}
