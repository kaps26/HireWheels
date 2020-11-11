package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.entities.VehicleCategory;
import com.upgrad.hirewheels.entities.VehicleSubcategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VehicleDao extends JpaRepository<Vehicle, Integer> {

    List<Vehicle> findByVehicleSubcategory(VehicleSubcategory vehicleSubcategory);
    Optional<Vehicle> findByVehicleNumber(String vehicleNumber);
    Optional<Vehicle> findByAvailabilityStatus(Integer id);
}
