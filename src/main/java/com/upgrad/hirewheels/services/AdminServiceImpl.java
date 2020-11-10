package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.VehicleDao;
import com.upgrad.hirewheels.entities.Users;
import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.exceptions.UnauthorizedUserException;
import com.upgrad.hirewheels.exceptions.UserNotRegisteredException;
import com.upgrad.hirewheels.exceptions.VehicleAlreadyExistsException;
import com.upgrad.hirewheels.exceptions.VehicleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private VehicleDao vehicleDao;

    @Autowired
    private UserService userService;

    public Vehicle registerVehicle(
            Vehicle vehicle,
            Users users)
            throws UserNotRegisteredException, UnauthorizedUserException, VehicleAlreadyExistsException {

        if (userService.getUsers(users).getRole().getRoleName().equals("ADMIN")) {
            if (vehicleDao.findByVehicleNumber(vehicle.getVehicleNumber()).isPresent()) {
                throw new VehicleAlreadyExistsException("Vehicle Already exists");
            }
            vehicle.setAvailableStatus(1);
            return vehicleDao.save(vehicle);
        } else {
            throw new UnauthorizedUserException("You are unauthorized to register vehicle");
        }
    }

    @Override
    public Vehicle changeAvailability(
            Vehicle vehicle,
            int status,
            Users users)
            throws UserNotRegisteredException, UnauthorizedUserException, VehicleNotFoundException {


        if (userService.getUsers(users).getRole().getRoleName().equals("ADMIN")) {
            Vehicle updatedVehicle = vehicleDao.findById(vehicle.getVehicleId()).orElseThrow(() -> new VehicleNotFoundException("Vehicle not found"));
            updatedVehicle.setAvailableStatus(status);
            return vehicleDao.save(updatedVehicle);
        } else {
            throw new UnauthorizedUserException("You are unauthorized to change the status");
        }

    }
}
