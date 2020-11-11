package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.UsersDao;
import com.upgrad.hirewheels.entities.Users;
import com.upgrad.hirewheels.exceptions.UserAlreadyExistsException;
import com.upgrad.hirewheels.exceptions.UserNotRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Qualifier("usersDao")
    @Autowired
    private UsersDao usersDao;

    @Autowired
    UserService userService;


    @Override
    public Users createUser(Users users) throws UserAlreadyExistsException{
        if(usersDao.findByEmailIgnoreCase(users.getEmail()).isPresent() ){
            throw new UserAlreadyExistsException("Email already exists");

        }
        else if(usersDao.findByMobileNo(users.getMobileNo()).isPresent()){
            throw new UserAlreadyExistsException("Mobile number already exists");
        }
        return usersDao.save(users);
    }

    public Users getUser(String email,String password) throws UserNotRegisteredException {
        return usersDao.findByEmailIgnoreCase(email)
                .orElseThrow(
                        () -> new UserNotRegisteredException("User not registered")
                );
    }
}
