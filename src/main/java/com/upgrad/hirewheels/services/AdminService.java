package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.entities.Users;
import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.exceptions.UnauthorizedUserException;
import com.upgrad.hirewheels.exceptions.UserNotRegisteredException;
import com.upgrad.hirewheels.exceptions.VehicleAlreadyExistsException;
import com.upgrad.hirewheels.exceptions.VehicleNotFoundException;


public interface AdminService {


    Vehicle registerVehicle(Vehicle vehicle, Users users) throws UserNotRegisteredException, UnauthorizedUserException, VehicleAlreadyExistsException;

    public Vehicle changeAvailability(Vehicle vehicle, int status, Users users) throws VehicleNotFoundException, UserNotRegisteredException, UnauthorizedUserException;
}
