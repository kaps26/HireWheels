package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UsersDao extends JpaRepository<Users, Integer> {

    public List<Users> findByFirstNameIgnoreCase(String firstName);
    public List<Users> findByFirstNameOrLastNameIgnoreCase(String firstName, String lastName);
    public List<Users> findByEmailIgnoreCase (String email);
    public List<Users> findByMobileNoIgnoreCase(String mobileNo);
}
