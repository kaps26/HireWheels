package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.entities.Users;
import com.upgrad.hirewheels.exceptions.MobileNoAlreadyExists;
import com.upgrad.hirewheels.exceptions.UnauthorizedUserException;
import com.upgrad.hirewheels.exceptions.UserAlreadyExistsException;
import com.upgrad.hirewheels.exceptions.UserNotRegisteredException;
import org.springframework.stereotype.Service;


public interface UserService {
    Users createUser(Users users) throws UserAlreadyExistsException, MobileNoAlreadyExists;
    Users getUsers(Users users) throws UserNotRegisteredException, UnauthorizedUserException;
}
