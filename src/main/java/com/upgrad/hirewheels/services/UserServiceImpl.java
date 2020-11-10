package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.UsersDao;
import com.upgrad.hirewheels.entities.Users;
import com.upgrad.hirewheels.exceptions.MobileNoAlreadyExists;
import com.upgrad.hirewheels.exceptions.UnauthorizedUserException;
import com.upgrad.hirewheels.exceptions.UserAlreadyExistsException;
import com.upgrad.hirewheels.exceptions.UserNotRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersDao usersDao;

    @Override
    public Users createUser(Users users) throws UserAlreadyExistsException, MobileNoAlreadyExists {
        if (usersDao.findByEmailIgnoreCase(users.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("Email Already Exists");
        }
        if (usersDao.findByMobileNo(users.getMobileNo()).isPresent()) {
            throw new MobileNoAlreadyExists("Mobile Number Already Exists");
        }
        return usersDao.save(users);
    }

    @Override
    public Users getUsers(Users user) throws UserNotRegisteredException, UnauthorizedUserException {
        Users loggedUser = usersDao.findByEmailIgnoreCase(user.getEmail()).orElseThrow(
                () -> new UserNotRegisteredException("User not Registered"));
        if (loggedUser.getPassword().equals(user.getPassword())) {
            return loggedUser;
        } else {
            throw new UnauthorizedUserException("Unauthorized User");
        }
    }
}
