package com.upgrad.hirewheels.controllers;

import com.upgrad.hirewheels.dao.VehicleCategoryDao;
import com.upgrad.hirewheels.exceptions.VehicleNotFoundException;
import org.modelmapper.ModelMapper;
import com.upgrad.hirewheels.dto.VehicleDTO;
import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    VehicleCategoryDao vehicleCategoryDao;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping(value= {"/hirewheels/v1/vehicles"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getVehicles(@RequestParam(name = "categoryName") String categoryName, @RequestParam(name="pickUpDate") LocalDateTime pickUpDate, @RequestParam(name="dropDate")LocalDateTime dropDate, @RequestParam(name="locationId") int locationId) throws VehicleNotFoundException {
        List<Vehicle> vehicleList=vehicleService.getAllVehicles();
        List<VehicleDTO> vehicleDTOList=new ArrayList<>();
        for(Vehicle vehicle:vehicleList){
            if(vehicle.getVehicleSubcategory().equals(categoryName)&& vehicle.getLocation().equals(locationId) && vehicle.getBookings().equals(pickUpDate) && vehicle.getBookings().equals(dropDate)) {
                vehicleDTOList.add(modelMapper.map(vehicle, VehicleDTO.class));
            }
            else{
                return null;
            }
        }
        return new ResponseEntity<>(vehicleDTOList,HttpStatus.OK);
    }
}
