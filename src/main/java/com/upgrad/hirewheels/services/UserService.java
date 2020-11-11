package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.entities.Users;
import com.upgrad.hirewheels.exceptions.UserAlreadyExistsException;
import com.upgrad.hirewheels.exceptions.UserNotRegisteredException;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public Users createUser(Users users) throws UserAlreadyExistsException;
    public Users getUser(String email,String password) throws UserNotRegisteredException;
}
